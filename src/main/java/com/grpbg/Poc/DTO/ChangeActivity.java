package com.grpbg.Poc.DTO;

public class ChangeActivity {

	public ChangeActivity() {

	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	private String plannedStartDate;

	public String getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public ChangeActivity(String plannedStartDate, String plannedFinalDate, String operatorGroup, String operator,
			String changeId, String briefDescription, String activityType, String changePhase, String status) {
		super();
		this.plannedStartDate = plannedStartDate;
		this.plannedFinalDate = plannedFinalDate;
		this.operatorGroup = operatorGroup;
		this.operator = operator;
		this.changeId = changeId;
		this.briefDescription = briefDescription;
		this.activityType = activityType;
		this.changePhase = changePhase;
		this.status = status;
	}

	private String plannedFinalDate;

	public String getPlannedFinalDate() {
		return plannedFinalDate;
	}

	public void setPlannedFinalDate(String plannedFinalDate) {
		this.plannedFinalDate = plannedFinalDate;
	}

	private String operatorGroup;

	public String getOperatorGroup() {
		return operatorGroup;
	}

	public void setOperatorGroup(String operatorGroup) {
		this.operatorGroup = operatorGroup;
	}

	private String operator;

	private String changeId;

	private String briefDescription;

	private String activityType; // "normal"

	private String changePhase; // "progress" /*

	private String status; // "Planned"

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getChangePhase() {
		return changePhase;
	}

	public void setChangePhase(String changePhase) {
		this.changePhase = changePhase;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
