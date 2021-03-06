package com.placecube.nhs.user.expando.expando;

import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.pfiks.expando.creator.ExpandoColumnCreator;
import com.pfiks.expando.creator.ExpandoColumnCreatorInputStreamService;
import com.pfiks.expando.exception.ExpandoColumnCreationException;
import com.placecube.nhs.user.expando.constants.UserExpando;

@Component(immediate = true, property = { "expandocolumn.creator=user.professional-area" }, service = ExpandoColumnCreator.class)
public class ProfessionalAreaColumnCreator implements ExpandoColumnCreator {

	@Reference
	private ExpandoColumnCreatorInputStreamService expandoColumnCreatorInputStreamService;

	@Override
	public ExpandoColumn create(Company company) throws ExpandoColumnCreationException {
		InputStream inputStream = ProfessionalAreaColumnCreator.class.getClassLoader()
				.getResourceAsStream("com/placecube/nhs/user/expando/dependencies/expando/" + UserExpando.PROFESSIONAL_AREA.getFieldName() + ".xml");
		return expandoColumnCreatorInputStreamService.createExpandoColumn(company, User.class.getName(), inputStream);
	}

}
