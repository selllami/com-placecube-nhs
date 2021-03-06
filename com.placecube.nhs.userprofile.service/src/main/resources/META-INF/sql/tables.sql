create table NHS_Experience (
	uuid_ VARCHAR(75) null,
	experienceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	placeOfWork VARCHAR(500) null,
	role_ VARCHAR(500) null,
	current BOOLEAN,
	fromDate DATE null,
	toDate DATE null,
	validated BOOLEAN
);

create table NHS_ProfessionalBody (
	uuid_ VARCHAR(75) null,
	professionalBodyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	registrationNumber VARCHAR(75) null,
	lastUpdateDate DATE null,
	revalidationDate DATE null,
	validated BOOLEAN
);

create table NHS_Qualification (
	uuid_ VARCHAR(75) null,
	qualificationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	place VARCHAR(500) null,
	qualification VARCHAR(500) null,
	fromDate DATE null,
	toDate DATE null,
	validated BOOLEAN
);