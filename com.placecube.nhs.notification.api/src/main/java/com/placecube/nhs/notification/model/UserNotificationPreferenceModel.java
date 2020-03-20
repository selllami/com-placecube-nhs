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

package com.placecube.nhs.notification.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import com.placecube.nhs.notification.service.persistence.UserNotificationPreferencePK;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the UserNotificationPreference service. Represents a row in the &quot;NHS_Notification_UserNotificationPreference&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.placecube.nhs.notification.model.impl.UserNotificationPreferenceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserNotificationPreference
 * @generated
 */
@ProviderType
public interface UserNotificationPreferenceModel
	extends BaseModel<UserNotificationPreference> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user notification preference model instance should use the {@link UserNotificationPreference} interface instead.
	 */

	/**
	 * Returns the primary key of this user notification preference.
	 *
	 * @return the primary key of this user notification preference
	 */
	public UserNotificationPreferencePK getPrimaryKey();

	/**
	 * Sets the primary key of this user notification preference.
	 *
	 * @param primaryKey the primary key of this user notification preference
	 */
	public void setPrimaryKey(UserNotificationPreferencePK primaryKey);

	/**
	 * Returns the uuid of this user notification preference.
	 *
	 * @return the uuid of this user notification preference
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this user notification preference.
	 *
	 * @param uuid the uuid of this user notification preference
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user ID of this user notification preference.
	 *
	 * @return the user ID of this user notification preference
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user notification preference.
	 *
	 * @param userId the user ID of this user notification preference
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user notification preference.
	 *
	 * @return the user uuid of this user notification preference
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this user notification preference.
	 *
	 * @param userUuid the user uuid of this user notification preference
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the notification type of this user notification preference.
	 *
	 * @return the notification type of this user notification preference
	 */
	@AutoEscape
	public String getNotificationType();

	/**
	 * Sets the notification type of this user notification preference.
	 *
	 * @param notificationType the notification type of this user notification preference
	 */
	public void setNotificationType(String notificationType);

	/**
	 * Returns the create date of this user notification preference.
	 *
	 * @return the create date of this user notification preference
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user notification preference.
	 *
	 * @param createDate the create date of this user notification preference
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this user notification preference.
	 *
	 * @return the modified date of this user notification preference
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this user notification preference.
	 *
	 * @param modifiedDate the modified date of this user notification preference
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the enabled of this user notification preference.
	 *
	 * @return the enabled of this user notification preference
	 */
	public boolean getEnabled();

	/**
	 * Returns <code>true</code> if this user notification preference is enabled.
	 *
	 * @return <code>true</code> if this user notification preference is enabled; <code>false</code> otherwise
	 */
	public boolean isEnabled();

	/**
	 * Sets whether this user notification preference is enabled.
	 *
	 * @param enabled the enabled of this user notification preference
	 */
	public void setEnabled(boolean enabled);

}