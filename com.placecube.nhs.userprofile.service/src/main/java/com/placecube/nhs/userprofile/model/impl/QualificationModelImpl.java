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

import com.placecube.nhs.userprofile.model.Qualification;
import com.placecube.nhs.userprofile.model.QualificationModel;

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
 * The base model implementation for the Qualification service. Represents a row in the &quot;NHS_Qualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>QualificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QualificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationImpl
 * @generated
 */
@ProviderType
public class QualificationModelImpl
	extends BaseModelImpl<Qualification> implements QualificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a qualification model instance should use the <code>Qualification</code> interface instead.
	 */
	public static final String TABLE_NAME = "NHS_Qualification";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"qualificationId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"place", Types.VARCHAR},
		{"qualification", Types.VARCHAR}, {"fromDate", Types.TIMESTAMP},
		{"toDate", Types.TIMESTAMP}, {"validated", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("qualificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("place", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("qualification", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fromDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("toDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("validated", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NHS_Qualification (uuid_ VARCHAR(75) null,qualificationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,place VARCHAR(500) null,qualification VARCHAR(500) null,fromDate DATE null,toDate DATE null,validated BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table NHS_Qualification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY qualification.fromDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NHS_Qualification.fromDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long USERID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long FROMDATE_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public QualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _qualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _qualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Qualification.class;
	}

	@Override
	public String getModelClassName() {
		return Qualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Qualification)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Qualification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Qualification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Qualification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Qualification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Qualification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Qualification>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Qualification.class.getClassLoader(), Qualification.class,
			ModelWrapper.class);

		try {
			Constructor<Qualification> constructor =
				(Constructor<Qualification>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Qualification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Qualification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Qualification, Object>>();
		Map<String, BiConsumer<Qualification, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Qualification, ?>>();

		attributeGetterFunctions.put("uuid", Qualification::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Qualification, String>)Qualification::setUuid);
		attributeGetterFunctions.put(
			"qualificationId", Qualification::getQualificationId);
		attributeSetterBiConsumers.put(
			"qualificationId",
			(BiConsumer<Qualification, Long>)Qualification::setQualificationId);
		attributeGetterFunctions.put("companyId", Qualification::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<Qualification, Long>)Qualification::setCompanyId);
		attributeGetterFunctions.put("userId", Qualification::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<Qualification, Long>)Qualification::setUserId);
		attributeGetterFunctions.put("userName", Qualification::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<Qualification, String>)Qualification::setUserName);
		attributeGetterFunctions.put(
			"createDate", Qualification::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Qualification, Date>)Qualification::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Qualification::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Qualification, Date>)Qualification::setModifiedDate);
		attributeGetterFunctions.put("place", Qualification::getPlace);
		attributeSetterBiConsumers.put(
			"place",
			(BiConsumer<Qualification, String>)Qualification::setPlace);
		attributeGetterFunctions.put(
			"qualification", Qualification::getQualification);
		attributeSetterBiConsumers.put(
			"qualification",
			(BiConsumer<Qualification, String>)Qualification::setQualification);
		attributeGetterFunctions.put("fromDate", Qualification::getFromDate);
		attributeSetterBiConsumers.put(
			"fromDate",
			(BiConsumer<Qualification, Date>)Qualification::setFromDate);
		attributeGetterFunctions.put("toDate", Qualification::getToDate);
		attributeSetterBiConsumers.put(
			"toDate",
			(BiConsumer<Qualification, Date>)Qualification::setToDate);
		attributeGetterFunctions.put("validated", Qualification::getValidated);
		attributeSetterBiConsumers.put(
			"validated",
			(BiConsumer<Qualification, Boolean>)Qualification::setValidated);

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
	public long getQualificationId() {
		return _qualificationId;
	}

	@Override
	public void setQualificationId(long qualificationId) {
		_qualificationId = qualificationId;
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
	public String getPlace() {
		if (_place == null) {
			return "";
		}
		else {
			return _place;
		}
	}

	@Override
	public void setPlace(String place) {
		_place = place;
	}

	@Override
	public String getQualification() {
		if (_qualification == null) {
			return "";
		}
		else {
			return _qualification;
		}
	}

	@Override
	public void setQualification(String qualification) {
		_qualification = qualification;
	}

	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		_columnBitmask = -1L;

		_fromDate = fromDate;
	}

	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		_toDate = toDate;
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
			PortalUtil.getClassNameId(Qualification.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Qualification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Qualification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		QualificationImpl qualificationImpl = new QualificationImpl();

		qualificationImpl.setUuid(getUuid());
		qualificationImpl.setQualificationId(getQualificationId());
		qualificationImpl.setCompanyId(getCompanyId());
		qualificationImpl.setUserId(getUserId());
		qualificationImpl.setUserName(getUserName());
		qualificationImpl.setCreateDate(getCreateDate());
		qualificationImpl.setModifiedDate(getModifiedDate());
		qualificationImpl.setPlace(getPlace());
		qualificationImpl.setQualification(getQualification());
		qualificationImpl.setFromDate(getFromDate());
		qualificationImpl.setToDate(getToDate());
		qualificationImpl.setValidated(isValidated());

		qualificationImpl.resetOriginalValues();

		return qualificationImpl;
	}

	@Override
	public int compareTo(Qualification qualification) {
		int value = 0;

		value = DateUtil.compareTo(getFromDate(), qualification.getFromDate());

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

		if (!(obj instanceof Qualification)) {
			return false;
		}

		Qualification qualification = (Qualification)obj;

		long primaryKey = qualification.getPrimaryKey();

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
		QualificationModelImpl qualificationModelImpl = this;

		qualificationModelImpl._originalUuid = qualificationModelImpl._uuid;

		qualificationModelImpl._originalCompanyId =
			qualificationModelImpl._companyId;

		qualificationModelImpl._setOriginalCompanyId = false;

		qualificationModelImpl._originalUserId = qualificationModelImpl._userId;

		qualificationModelImpl._setOriginalUserId = false;

		qualificationModelImpl._setModifiedDate = false;

		qualificationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Qualification> toCacheModel() {
		QualificationCacheModel qualificationCacheModel =
			new QualificationCacheModel();

		qualificationCacheModel.uuid = getUuid();

		String uuid = qualificationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			qualificationCacheModel.uuid = null;
		}

		qualificationCacheModel.qualificationId = getQualificationId();

		qualificationCacheModel.companyId = getCompanyId();

		qualificationCacheModel.userId = getUserId();

		qualificationCacheModel.userName = getUserName();

		String userName = qualificationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			qualificationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			qualificationCacheModel.createDate = createDate.getTime();
		}
		else {
			qualificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			qualificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			qualificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		qualificationCacheModel.place = getPlace();

		String place = qualificationCacheModel.place;

		if ((place != null) && (place.length() == 0)) {
			qualificationCacheModel.place = null;
		}

		qualificationCacheModel.qualification = getQualification();

		String qualification = qualificationCacheModel.qualification;

		if ((qualification != null) && (qualification.length() == 0)) {
			qualificationCacheModel.qualification = null;
		}

		Date fromDate = getFromDate();

		if (fromDate != null) {
			qualificationCacheModel.fromDate = fromDate.getTime();
		}
		else {
			qualificationCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			qualificationCacheModel.toDate = toDate.getTime();
		}
		else {
			qualificationCacheModel.toDate = Long.MIN_VALUE;
		}

		qualificationCacheModel.validated = isValidated();

		return qualificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Qualification)this));
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
		Map<String, Function<Qualification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Qualification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qualification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Qualification)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Qualification>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _qualificationId;
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
	private String _place;
	private String _qualification;
	private Date _fromDate;
	private Date _toDate;
	private boolean _validated;
	private long _columnBitmask;
	private Qualification _escapedModel;

}