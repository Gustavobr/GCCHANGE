package com.grpbg.Poc.DTO;

public class NotStarting {
	
	
	private String[] possibleStatus = {"planned"};
	
	private String id;
	
	private String name;

	public String[] getPossibleStatus() {
		return possibleStatus;
	}

	public void setPossibleStatus(String[] possibleStatus) {
		this.possibleStatus = possibleStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
