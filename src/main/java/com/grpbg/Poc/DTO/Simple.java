package com.grpbg.Poc.DTO;

public class Simple {
	
	private String plannedStartDate;
	
	private String startDate;
	
	private String plannedImplementationDate;
	
	public String getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getPlannedImplementationDate() {
		return plannedImplementationDate;
	}

	public void setPlannedImplementationDate(String plannedImplementationDate) {
		this.plannedImplementationDate = plannedImplementationDate;
	}

	public String getImplementationDate() {
		return implementationDate;
	}

	public void setImplementationDate(String implementationDate) {
		this.implementationDate = implementationDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public Assignee getAssignee() {
		return assignee;
	}

	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}

	private String implementationDate;
	
	private String closedDate;
	
	private Assignee assignee;
	
	
	

}
