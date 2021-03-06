/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.placecube.nhs.userprofile.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ProfessionalBody service. Represents a row in the &quot;NHS_ProfessionalBody&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.placecube.nhs.userprofile.model.impl.ProfessionalBodyImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBody
 * @generated
 */
@ProviderType
public interface ProfessionalBodyModel
	extends BaseModel<ProfessionalBody>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a professional body model instance should use the {@link ProfessionalBody} interface instead.
	 */

	/**
	 * Returns the primary key of this professional body.
	 *
	 * @return the primary key of this professional body
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this professional body.
	 *
	 * @param primaryKey the primary key of this professional body
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this professional body.
	 *
	 * @return the uuid of this professional body
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this professional body.
	 *
	 * @param uuid the uuid of this professional body
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the professional body ID of this professional body.
	 *
	 * @return the professional body ID of this professional body
	 */
	public long getProfessionalBodyId();

	/**
	 * Sets the professional body ID of this professional body.
	 *
	 * @param professionalBodyId the professional body ID of this professional body
	 */
	public void setProfessionalBodyId(long professionalBodyId);

	/**
	 * Returns the company ID of this professional body.
	 *
	 * @return the company ID of this professional body
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this professional body.
	 *
	 * @param companyId the company ID of this professional body
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this professional body.
	 *
	 * @return the user ID of this professional body
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this professional body.
	 *
	 * @param userId the user ID of this professional body
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this professional body.
	 *
	 * @return the user uuid of this professional body
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this professional body.
	 *
	 * @param userUuid the user uuid of this professional body
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this professional body.
	 *
	 * @return the user name of this professional body
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this professional body.
	 *
	 * @param userName the user name of this professional body
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this professional body.
	 *
	 * @return the create date of this professional body
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this professional body.
	 *
	 * @param createDate the create date of this professional body
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this professional body.
	 *
	 * @return the modified date of this professional body
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this professional body.
	 *
	 * @param modifiedDate the modified date of this professional body
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this professional body.
	 *
	 * @return the title of this professional body
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this professional body.
	 *
	 * @param title the title of this professional body
	 */
	public void setTitle(String title);

	/**
	 * Returns the registration number of this professional body.
	 *
	 * @return the registration number of this professional body
	 */
	@AutoEscape
	public String getRegistrationNumber();

	/**
	 * Sets the registration number of this professional body.
	 *
	 * @param registrationNumber the registration number of this professional body
	 */
	public void setRegistrationNumber(String registrationNumber);

	/**
	 * Returns the last update date of this professional body.
	 *
	 * @return the last update date of this professional body
	 */
	public Date getLastUpdateDate();

	/**
	 * Sets the last update date of this professional body.
	 *
	 * @param lastUpdateDate the last update date of this professional body
	 */
	public void setLastUpdateDate(Date lastUpdateDate);

	/**
	 * Returns the revalidation date of this professional body.
	 *
	 * @return the revalidation date of this professional body
	 */
	public Date getRevalidationDate();

	/**
	 * Sets the revalidation date of this professional body.
	 *
	 * @param revalidationDate the revalidation date of this professional body
	 */
	public void setRevalidationDate(Date revalidationDate);

	/**
	 * Returns the validated of this professional body.
	 *
	 * @return the validated of this professional body
	 */
	public boolean getValidated();

	/**
	 * Returns <code>true</code> if this professional body is validated.
	 *
	 * @return <code>true</code> if this professional body is validated; <code>false</code> otherwise
	 */
	public boolean isValidated();

	/**
	 * Sets whether this professional body is validated.
	 *
	 * @param validated the validated of this professional body
	 */
	public void setValidated(boolean validated);

}