package com.placecube.nhs.webcontentlisting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.search.utils.SearchService;
import com.placecube.nhs.taglibs.model.AZEntry;
import com.placecube.nhs.webcontentlisting.portlet.az.configuration.AZWebContentPortletInstanceConfiguration;
import com.placecube.nhs.webcontentlisting.portlet.mostpopular.configuration.MostPopularWebContentPortletInstanceConfiguration;

@Component(immediate = true, service = WebContentListingService.class)
public class WebContentListingService {

	private static final Log LOG = LogFactoryUtil.getLog(WebContentListingService.class);

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private DDMStructureLocalService ddmStructureLocalService;

	@Reference
	private SearchService searchService;

	@Reference
	private WebContentRetrievalService webContentRetrievalService;

	@Reference
	private GroupLocalService groupLocalService;

	public AZWebContentPortletInstanceConfiguration getAZConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		AZWebContentPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(AZWebContentPortletInstanceConfiguration.class);
		if (skipValidation || Validator.isNotNull(configuration.structureKey())) {
			return configuration;
		}
		throw new ConfigurationException("Invalid configuration");
	}

	public MostPopularWebContentPortletInstanceConfiguration getMostPopularConfiguration(ThemeDisplay themeDisplay, boolean skipValidation) throws ConfigurationException {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		MostPopularWebContentPortletInstanceConfiguration configuration = portletDisplay.getPortletInstanceConfiguration(MostPopularWebContentPortletInstanceConfiguration.class);
		if (skipValidation || Validator.isNotNull(configuration.structureKey()) && Validator.isNotNull(configuration.templateKey()) && configuration.maxItemsToDisplay() > 0) {
			return configuration;
		}
		throw new ConfigurationException("Invalid configuration");
	}

	public List<AZEntry> getAllWebContents(ThemeDisplay themeDisplay, String currentPageURL, String structureKey, Optional<BooleanClause<Query>> queryOnMatchingCategories) throws SearchException {
		List<AZEntry> results = new ArrayList<>();

		SearchContext searchContext = webContentRetrievalService.getSearchContext(themeDisplay.getCompanyId(), structureKey, -1, queryOnMatchingCategories);
		Document[] searchResults = webContentRetrievalService.getSearchResults(searchContext);
		for (Document document : searchResults) {
			try {
				results.add(webContentRetrievalService.getAZEntryFromSearchResult(document, themeDisplay, currentPageURL));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

	public List<JournalArticleDisplay> getMostPopularWebContents(ThemeDisplay themeDisplay, Integer maxItemsToDisplay, String structureKey, String templateKey,
			Optional<BooleanClause<Query>> queryOnMatchingCategories) throws SearchException {
		List<JournalArticleDisplay> results = new ArrayList<>();

		SearchContext searchContext = webContentRetrievalService.getSearchContext(themeDisplay.getCompanyId(), structureKey, maxItemsToDisplay, queryOnMatchingCategories);
		Document[] searchResults = webContentRetrievalService.getSearchResults(searchContext);

		for (Document document : searchResults) {
			try {
				results.add(webContentRetrievalService.getJournalArticleDisplayFromSearchResult(document, themeDisplay, templateKey));
			} catch (Exception e) {
				LOG.debug(e);
			}
		}
		return results;
	}

	public Optional<BooleanClause<Query>> getQueryOnMatchingCategories(long companyId, boolean matchingCategories, long scopeGroupId) throws SearchException {
		try {
			if (matchingCategories) {
				long[] categoryIds = assetEntryLocalService.getEntry(Group.class.getName(), scopeGroupId).getCategoryIds();

				String groupIdsQuery = searchService.getValuesJoinedInOr(Field.GROUP_ID, getGroupIdsWithCategories(companyId, scopeGroupId, categoryIds));
				String categoryIdsQuery = searchService.getValuesJoinedInOr(Field.ASSET_CATEGORY_IDS, categoryIds);

				String queryString = Stream.of(groupIdsQuery, categoryIdsQuery).filter(query -> Validator.isNotNull(query)).collect(Collectors.joining(" OR "));
				if (Validator.isNotNull(queryString)) {
					return Optional.of(searchService.getStringQuery(queryString, BooleanClauseOccur.MUST));
				}

			}
		} catch (Exception e) {
			LOG.debug(e);
			LOG.warn("Unable to get categories from groupId: " + scopeGroupId + " - " + e.getMessage());
		}
		return Optional.empty();
	}

	private long[] getGroupIdsWithCategories(long companyId, long groupId, long[] categoryIds) throws SearchException {
		SearchContext searchContext = searchService.getSearchContext(companyId);
		BooleanClause<Query> queryOnCategoryIds = searchService.getStringQuery(Field.ASSET_CATEGORY_IDS, categoryIds, BooleanClauseOccur.MUST);
		searchService.configureBooleanClauses(searchContext, queryOnCategoryIds);

		Document[] searchResults = searchService.getSearchResults(searchContext, Group.class.getName());
		List<Long> groupIds = new ArrayList<>();
		for (Document document : searchResults) {
			groupIds.add(GetterUtil.getLong(document.get(Field.GROUP_ID)));
		}

		return ArrayUtil.toArray(groupIds.toArray(new Long[groupIds.size()]));
	}

}
