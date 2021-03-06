package com.placecube.nhs.webcontent.structures.constants;

public enum WebContentStructure {

	COURSE("COURSE", "COURSE", "COURSE-LISTING"),

	JOB("JOB", "JOB", "JOB-LISTING");

	private final String structureKey;
	private final String fullDisplayTemplateKey;
	private final String listingTemplateKey;

	private WebContentStructure(String structureKey, String fullDisplayTemplateKey, String listingTemplateKey) {
		this.structureKey = structureKey;
		this.fullDisplayTemplateKey = fullDisplayTemplateKey;
		this.listingTemplateKey = listingTemplateKey;
	}

	public String getFullDisplayTemplateKey() {
		return fullDisplayTemplateKey;
	}

	public String getListingTemplateKey() {
		return listingTemplateKey;
	}

	public String getStructureKey() {
		return structureKey;
	}

}
