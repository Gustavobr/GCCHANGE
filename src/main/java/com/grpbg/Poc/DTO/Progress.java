package com.grpbg.Poc.DTO;

public class Progress {

	private String plannedEndDate;

	private String endDate;

	private Authorizer authorizer;

	public String getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(String plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Authorizer getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(Authorizer authorizer) {
		this.authorizer = authorizer;
	}
}
