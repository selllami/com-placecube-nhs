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
 * The base model interface for the Qualification service. Represents a row in the &quot;NHS_Qualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.placecube.nhs.userprofile.model.impl.QualificationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.placecube.nhs.userprofile.model.impl.QualificationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Qualification
 * @generated
 */
@ProviderType
public interface QualificationModel
	extends BaseModel<Qualification>, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a qualification model instance should use the {@link Qualification} interface instead.
	 */

	/**
	 * Returns the primary key of this qualification.
	 *
	 * @return the primary key of this qualification
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this qualification.
	 *
	 * @param primaryKey the primary key of this qualification
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this qualification.
	 *
	 * @return the uuid of this qualification
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this qualification.
	 *
	 * @param uuid the uuid of this qualification
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the qualification ID of this qualification.
	 *
	 * @return the qualification ID of this qualification
	 */
	public long getQualificationId();

	/**
	 * Sets the qualification ID of this qualification.
	 *
	 * @param qualificationId the qualification ID of this qualification
	 */
	public void setQualificationId(long qualificationId);

	/**
	 * Returns the company ID of this qualification.
	 *
	 * @return the company ID of this qualification
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this qualification.
	 *
	 * @param companyId the company ID of this qualification
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this qualification.
	 *
	 * @return the user ID of this qualification
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this qualification.
	 *
	 * @param userId the user ID of this qualification
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this qualification.
	 *
	 * @return the user uuid of this qualification
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this qualification.
	 *
	 * @param userUuid the user uuid of this qualification
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this qualification.
	 *
	 * @return the user name of this qualification
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this qualification.
	 *
	 * @param userName the user name of this qualification
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this qualification.
	 *
	 * @return the create date of this qualification
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this qualification.
	 *
	 * @param createDate the create date of this qualification
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this qualification.
	 *
	 * @return the modified date of this qualification
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this qualification.
	 *
	 * @param modifiedDate the modified date of this qualification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the place of this qualification.
	 *
	 * @return the place of this qualification
	 */
	@AutoEscape
	public String getPlace();

	/**
	 * Sets the place of this qualification.
	 *
	 * @param place the place of this qualification
	 */
	public void setPlace(String place);

	/**
	 * Returns the qualification of this qualification.
	 *
	 * @return the qualification of this qualification
	 */
	@AutoEscape
	public String getQualification();

	/**
	 * Sets the qualification of this qualification.
	 *
	 * @param qualification the qualification of this qualification
	 */
	public void setQualification(String qualification);

	/**
	 * Returns the from date of this qualification.
	 *
	 * @return the from date of this qualification
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this qualification.
	 *
	 * @param fromDate the from date of this qualification
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this qualification.
	 *
	 * @return the to date of this qualification
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this qualification.
	 *
	 * @param toDate the to date of this qualification
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the validated of this qualification.
	 *
	 * @return the validated of this qualification
	 */
	public boolean getValidated();

	/**
	 * Returns <code>true</code> if this qualification is validated.
	 *
	 * @return <code>true</code> if this qualification is validated; <code>false</code> otherwise
	 */
	public boolean isValidated();

	/**
	 * Sets whether this qualification is validated.
	 *
	 * @param validated the validated of this qualification
	 */
	public void setValidated(boolean validated);

}