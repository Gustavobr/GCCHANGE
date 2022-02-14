package com.grpbg.Poc.DTO;

public class Template {
	
	private String id;
	
	private String number;
	
	private String[] optionalActivities;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String[] getOptionalActivities() {
		return optionalActivities;
	}

	public void setOptionalActivities(String[] optionalActivities) {
		this.optionalActivities = optionalActivities;
	}

}
