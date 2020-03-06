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

package com.placecube.nhs.userprofile.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.placecube.nhs.userprofile.model.ProfessionalBody;
import com.placecube.nhs.userprofile.model.ProfessionalBodyModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the ProfessionalBody service. Represents a row in the &quot;NHS_ProfessionalBody&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ProfessionalBodyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProfessionalBodyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalBodyImpl
 * @generated
 */
@ProviderType
public class ProfessionalBodyModelImpl
	extends BaseModelImpl<ProfessionalBody> implements ProfessionalBodyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a professional body model instance should use the <code>ProfessionalBody</code> interface instead.
	 */
	public static final String TABLE_NAME = "NHS_ProfessionalBody";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"professionalBodyId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"title", Types.VARCHAR},
		{"location", Types.VARCHAR}, {"expiryDate", Types.TIMESTAMP},
		{"validated", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("professionalBodyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("location", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expiryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("validated", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NHS_ProfessionalBody (uuid_ VARCHAR(75) null,professionalBodyId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,location VARCHAR(75) null,expiryDate DATE null,validated BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table NHS_ProfessionalBody";

	public static final String ORDER_BY_JPQL =
		" ORDER BY professionalBody.expiryDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NHS_ProfessionalBody.expiryDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long USERID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long EXPIRYDATE_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public ProfessionalBodyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _professionalBodyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProfessionalBodyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _professionalBodyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProfessionalBody.class;
	}

	@Override
	public String getModelClassName() {
		return ProfessionalBody.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProfessionalBody, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProfessionalBody, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalBody, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProfessionalBody)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProfessionalBody, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProfessionalBody, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProfessionalBody)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProfessionalBody, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProfessionalBody, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProfessionalBody>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProfessionalBody.class.getClassLoader(), ProfessionalBody.class,
			ModelWrapper.class);

		try {
			Constructor<ProfessionalBody> constructor =
				(Constructor<ProfessionalBody>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<ProfessionalBody, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProfessionalBody, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProfessionalBody, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ProfessionalBody, Object>>();
		Map<String, BiConsumer<ProfessionalBody, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ProfessionalBody, ?>>();

		attributeGetterFunctions.put("uuid", ProfessionalBody::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProfessionalBody, String>)ProfessionalBody::setUuid);
		attributeGetterFunctions.put(
			"professionalBodyId", ProfessionalBody::getProfessionalBodyId);
		attributeSetterBiConsumers.put(
			"professionalBodyId",
			(BiConsumer<ProfessionalBody, Long>)
				ProfessionalBody::setProfessionalBodyId);
		attributeGetterFunctions.put(
			"companyId", ProfessionalBody::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProfessionalBody, Long>)ProfessionalBody::setCompanyId);
		attributeGetterFunctions.put("userId", ProfessionalBody::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProfessionalBody, Long>)ProfessionalBody::setUserId);
		attributeGetterFunctions.put("userName", ProfessionalBody::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProfessionalBody, String>)
				ProfessionalBody::setUserName);
		attributeGetterFunctions.put(
			"createDate", ProfessionalBody::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProfessionalBody, Date>)
				ProfessionalBody::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProfessionalBody::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProfessionalBody, Date>)
				ProfessionalBody::setModifiedDate);
		attributeGetterFunctions.put("title", ProfessionalBody::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<ProfessionalBody, String>)ProfessionalBody::setTitle);
		attributeGetterFunctions.put("location", ProfessionalBody::getLocation);
		attributeSetterBiConsumers.put(
			"location",
			(BiConsumer<ProfessionalBody, String>)
				ProfessionalBody::setLocation);
		attributeGetterFunctions.put(
			"expiryDate", ProfessionalBody::getExpiryDate);
		attributeSetterBiConsumers.put(
			"expiryDate",
			(BiConsumer<ProfessionalBody, Date>)
				ProfessionalBody::setExpiryDate);
		attributeGetterFunctions.put(
			"validated", ProfessionalBody::getValidated);
		attributeSetterBiConsumers.put(
			"validated",
			(BiConsumer<ProfessionalBody, Boolean>)
				ProfessionalBody::setValidated);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getProfessionalBodyId() {
		return _professionalBodyId;
	}

	@Override
	public void setProfessionalBodyId(long professionalBodyId) {
		_professionalBodyId = professionalBodyId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getLocation() {
		if (_location == null) {
			return "";
		}
		else {
			return _location;
		}
	}

	@Override
	public void setLocation(String location) {
		_location = location;
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		_columnBitmask = -1L;

		_expiryDate = expiryDate;
	}

	@Override
	public boolean getValidated() {
		return _validated;
	}

	@Override
	public boolean isValidated() {
		return _validated;
	}

	@Override
	public void setValidated(boolean validated) {
		_validated = validated;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProfessionalBody.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProfessionalBody.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProfessionalBody toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProfessionalBodyImpl professionalBodyImpl = new ProfessionalBodyImpl();

		professionalBodyImpl.setUuid(getUuid());
		professionalBodyImpl.setProfessionalBodyId(getProfessionalBodyId());
		professionalBodyImpl.setCompanyId(getCompanyId());
		professionalBodyImpl.setUserId(getUserId());
		professionalBodyImpl.setUserName(getUserName());
		professionalBodyImpl.setCreateDate(getCreateDate());
		professionalBodyImpl.setModifiedDate(getModifiedDate());
		professionalBodyImpl.setTitle(getTitle());
		professionalBodyImpl.setLocation(getLocation());
		professionalBodyImpl.setExpiryDate(getExpiryDate());
		professionalBodyImpl.setValidated(isValidated());

		professionalBodyImpl.resetOriginalValues();

		return professionalBodyImpl;
	}

	@Override
	public int compareTo(ProfessionalBody professionalBody) {
		int value = 0;

		value = DateUtil.compareTo(
			getExpiryDate(), professionalBody.getExpiryDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfessionalBody)) {
			return false;
		}

		ProfessionalBody professionalBody = (ProfessionalBody)obj;

		long primaryKey = professionalBody.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		ProfessionalBodyModelImpl professionalBodyModelImpl = this;

		professionalBodyModelImpl._originalUuid =
			professionalBodyModelImpl._uuid;

		professionalBodyModelImpl._originalCompanyId =
			professionalBodyModelImpl._companyId;

		professionalBodyModelImpl._setOriginalCompanyId = false;

		professionalBodyModelImpl._originalUserId =
			professionalBodyModelImpl._userId;

		professionalBodyModelImpl._setOriginalUserId = false;

		professionalBodyModelImpl._setModifiedDate = false;

		professionalBodyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProfessionalBody> toCacheModel() {
		ProfessionalBodyCacheModel professionalBodyCacheModel =
			new ProfessionalBodyCacheModel();

		professionalBodyCacheModel.uuid = getUuid();

		String uuid = professionalBodyCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			professionalBodyCacheModel.uuid = null;
		}

		professionalBodyCacheModel.professionalBodyId = getProfessionalBodyId();

		professionalBodyCacheModel.companyId = getCompanyId();

		professionalBodyCacheModel.userId = getUserId();

		professionalBodyCacheModel.userName = getUserName();

		String userName = professionalBodyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			professionalBodyCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			professionalBodyCacheModel.createDate = createDate.getTime();
		}
		else {
			professionalBodyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			professionalBodyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			professionalBodyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		professionalBodyCacheModel.title = getTitle();

		String title = professionalBodyCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			professionalBodyCacheModel.title = null;
		}

		professionalBodyCacheModel.location = getLocation();

		String location = professionalBodyCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			professionalBodyCacheModel.location = null;
		}

		Date expiryDate = getExpiryDate();

		if (expiryDate != null) {
			professionalBodyCacheModel.expiryDate = expiryDate.getTime();
		}
		else {
			professionalBodyCacheModel.expiryDate = Long.MIN_VALUE;
		}

		professionalBodyCacheModel.validated = isValidated();

		return professionalBodyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProfessionalBody, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProfessionalBody, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalBody, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ProfessionalBody)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ProfessionalBody, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProfessionalBody, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalBody, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProfessionalBody)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, ProfessionalBody>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _professionalBodyId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _title;
	private String _location;
	private Date _expiryDate;
	private boolean _validated;
	private long _columnBitmask;
	private ProfessionalBody _escapedModel;

}