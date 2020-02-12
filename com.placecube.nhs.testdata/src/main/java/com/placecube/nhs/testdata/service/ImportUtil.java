package com.placecube.nhs.testdata.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(immediate = true, service = ImportUtil.class)
public class ImportUtil {

	private static final Log LOG = LogFactoryUtil.getLog(ImportUtil.class);

	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private JSONFactory jsonFactory;

	public JSONObject getJSONObject(String path) throws JSONException, IOException {
		return jsonFactory.createJSONObject(StringUtil.read(getClass().getClassLoader(), path));
	}

	public void importCategory(Long vocabularyId, JSONObject category, Long parentCategoryId, ServiceContext serviceContext) throws PortalException {
		String categoryName = category.getString("categoryName");
		LOG.info("Importing category with name: " + categoryName + ", parentCategoryId:" + parentCategoryId);
		AssetCategory assetCategory = assetCategoryLocalService.fetchCategory(serviceContext.getScopeGroupId(), parentCategoryId, categoryName, vocabularyId);
		if (Validator.isNull(assetCategory)) {
			assetCategoryLocalService.addCategory(serviceContext.getUserId(), serviceContext.getScopeGroupId(), parentCategoryId, Collections.singletonMap(serviceContext.getLocale(), categoryName),
					Collections.emptyMap(), vocabularyId, null, serviceContext);
		}
	}

	public JSONArray getJSONArray(String path, String arrayValue) throws JSONException, IOException {
		JSONObject jsonObject = getJSONObject(path);
		return jsonObject.getJSONArray(arrayValue);
	}

	public long importGroup(JSONObject groupJSON, long parentGroupId, List<AssetCategory> categories, ServiceContext serviceContext) {
		try {
			String groupName = groupJSON.getString("groupName");

			Group group = groupLocalService.fetchGroup(serviceContext.getCompanyId(), groupName);
			if (Validator.isNull(group)) {
				group = addGroup(groupJSON, parentGroupId, categories, serviceContext, groupName);
			}
			return group.getGroupId();
		} catch (PortalException e) {
			LOG.debug(e);
			LOG.error(e.getMessage());
			return GroupConstants.DEFAULT_PARENT_GROUP_ID;
		}
	}

	private Group addGroup(JSONObject group, long parentGroupId, List<AssetCategory> categories, ServiceContext serviceContext, String groupName) throws PortalException {
		LOG.info("Importing group : " + groupName);
		String typeLabel = group.getString("type");
		int type = Validator.isNull(typeLabel) || "open".equalsIgnoreCase(typeLabel) ? GroupConstants.TYPE_SITE_OPEN : GroupConstants.TYPE_SITE_RESTRICTED;
		serviceContext.setAssetCategoryIds(getCategoryIds(categories, group));
		return groupLocalService.addGroup(serviceContext.getUserId(), parentGroupId, Group.class.getName(), 0, GroupConstants.DEFAULT_LIVE_GROUP_ID,
				Collections.singletonMap(serviceContext.getLocale(), groupName), null, type, true, 0, null, true, true, serviceContext);
	}

	private long[] getCategoryIds(List<AssetCategory> assetCategories, JSONObject mappingJsonObject) {
		Set<Long> assetCategoryIdSet = new HashSet<>();
		JSONArray categories = mappingJsonObject.getJSONArray("categories");
		for (int i = 0; i < categories.length(); i++) {
			JSONObject category = categories.getJSONObject(i);
			String categoryName = category.getString("categoryName");
			assetCategoryIdSet.add(assetCategories.stream().filter(entry -> entry.getName().equals(categoryName)).findFirst().get().getCategoryId());
		}
		return ArrayUtils.toPrimitive(assetCategoryIdSet.toArray(new Long[assetCategoryIdSet.size()]));
	}

}
