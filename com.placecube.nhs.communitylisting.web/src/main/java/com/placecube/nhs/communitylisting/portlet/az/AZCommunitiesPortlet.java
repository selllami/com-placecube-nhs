package com.placecube.nhs.communitylisting.portlet.az;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.communitylisting.constants.PortletKeys;
import com.placecube.nhs.communitylisting.portlet.az.configuration.AZCommunityPortletInstanceConfiguration;
import com.placecube.nhs.communitylisting.service.CommunityListingService;
import com.placecube.nhs.communitylisting.service.ConfigurationService;

@Component(immediate = true, property = { "com.liferay.fragment.entry.processor.portlet.alias=communitylisting-az",
		"com.liferay.portlet.css-class-wrapper=portlet-communitylisting portlet-communitylisting-az", "com.liferay.portlet.display-category=category.nhs", "com.liferay.portlet.instanceable=false",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/az/view.jsp",
		"javax.portlet.security-role-ref=power-user,user", "javax.portlet.name=" + PortletKeys.AZ, "javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class AZCommunitiesPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(AZCommunitiesPortlet.class);

	@Reference
	private ConfigurationService configurationService;

	@Reference
	private CommunityListingService communityListingService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			AZCommunityPortletInstanceConfiguration configuration = configurationService.getAZConfiguration(themeDisplay, false);

			renderRequest.setAttribute("communities", communityListingService.getAllGroups(themeDisplay, configuration.groupTypes(), configuration.matchingCategories()));

		} catch (ConfigurationException e) {
			LOG.debug(e);
			renderRequest.setAttribute("invalidConfiguration", true);
		} catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}
}