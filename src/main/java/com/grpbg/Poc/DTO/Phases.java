package com.grpbg.Poc.DTO;


/* Change Phases for Details Endpoint  */


public class Phases {
	
	
	private String plannedEndDate;
	
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

	private String endDate;
	
	private Authorizer authorizer;

}
