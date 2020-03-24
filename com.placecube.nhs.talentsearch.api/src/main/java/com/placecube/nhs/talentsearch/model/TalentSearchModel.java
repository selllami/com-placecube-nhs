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

package com.placecube.nhs.talentsearch.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TalentSearch service. Represents a row in the &quot;NHS_TalentSearch_TalentSearch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.placecube.nhs.talentsearch.model.impl.TalentSearchModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.placecube.nhs.talentsearch.model.impl.TalentSearchImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TalentSearch
 * @generated
 */
@ProviderType
public interface TalentSearchModel
	extends BaseModel<TalentSearch>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a talent search model instance should use the {@link TalentSearch} interface instead.
	 */

	/**
	 * Returns the primary key of this talent search.
	 *
	 * @return the primary key of this talent search
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this talent search.
	 *
	 * @param primaryKey the primary key of this talent search
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this talent search.
	 *
	 * @return the uuid of this talent search
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this talent search.
	 *
	 * @param uuid the uuid of this talent search
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the talent search ID of this talent search.
	 *
	 * @return the talent search ID of this talent search
	 */
	public long getTalentSearchId();

	/**
	 * Sets the talent search ID of this talent search.
	 *
	 * @param talentSearchId the talent search ID of this talent search
	 */
	public void setTalentSearchId(long talentSearchId);

	/**
	 * Returns the company ID of this talent search.
	 *
	 * @return the company ID of this talent search
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this talent search.
	 *
	 * @param companyId the company ID of this talent search
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this talent search.
	 *
	 * @return the user ID of this talent search
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this talent search.
	 *
	 * @param userId the user ID of this talent search
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this talent search.
	 *
	 * @return the user uuid of this talent search
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this talent search.
	 *
	 * @param userUuid the user uuid of this talent search
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this talent search.
	 *
	 * @return the create date of this talent search
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this talent search.
	 *
	 * @param createDate the create date of this talent search
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this talent search.
	 *
	 * @return the modified date of this talent search
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this talent search.
	 *
	 * @param modifiedDate the modified date of this talent search
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this talent search.
	 *
	 * @return the name of this talent search
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this talent search.
	 *
	 * @param name the name of this talent search
	 */
	public void setName(String name);

	/**
	 * Returns the type ID of this talent search.
	 *
	 * @return the type ID of this talent search
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this talent search.
	 *
	 * @param typeId the type ID of this talent search
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns the category ID of this talent search.
	 *
	 * @return the category ID of this talent search
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this talent search.
	 *
	 * @param categoryId the category ID of this talent search
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the query filter of this talent search.
	 *
	 * @return the query filter of this talent search
	 */
	@AutoEscape
	public String getQueryFilter();

	/**
	 * Sets the query filter of this talent search.
	 *
	 * @param queryFilter the query filter of this talent search
	 */
	public void setQueryFilter(String queryFilter);

}