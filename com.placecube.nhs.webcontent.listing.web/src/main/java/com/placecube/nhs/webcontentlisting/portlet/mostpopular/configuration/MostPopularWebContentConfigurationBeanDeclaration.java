package com.placecube.nhs.webcontentlisting.portlet.mostpopular.configuration;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component(service = ConfigurationBeanDeclaration.class)
public class MostPopularWebContentConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return MostPopularWebContentPortletInstanceConfiguration.class;
	}

}
