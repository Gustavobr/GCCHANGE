package com.grpbg.Poc.DTO;

/* Pojo - ChangeDTO */
public class ChangeDTO {

	public ChangeDTO() {

	}

	private String type;

	private String groupId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	private String nome;

	private String filial;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlannedFinalDate() {
		return plannedFinalDate;
	}

	public ChangeDTO(String type, String groupId, String nome, String filial, String tokenID, String briefDescription,
			String request, String action, String changeType, String externalNumber, String category,
			String subcategory, String benefit, String impact, String priority, String plannedEndDate,
			String plannedFinalDate) {
		super();
		this.type = type;
		this.groupId = groupId;
		this.nome = nome;
		this.filial = filial;
		this.tokenID = tokenID;
		this.briefDescription = briefDescription;
		this.request = request;
		this.action = action;
		this.changeType = changeType;
		this.externalNumber = externalNumber;
		this.category = category;
		this.subcategory = subcategory;
		this.benefit = benefit;
		this.impact = impact;
		this.priority = priority;
		this.plannedEndDate = plannedEndDate;
		this.plannedFinalDate = plannedFinalDate;
	}

	public void setPlannedFinalDate(String plannedFinalDate) {
		this.plannedFinalDate = plannedFinalDate;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	private String tokenID;

	private String briefDescription;

	private String request;

	private String action;

	private String changeType;

	private String externalNumber;

	private String category;

	private String subcategory;

	private String benefit;

	private String impact;

	private String priority;

	private String plannedEndDate;

	private String plannedFinalDate;

	public String getTokenID() {
		return tokenID;
	}

	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getExternalNumber() {
		return externalNumber;
	}

	public void setExternalNumber(String externalNumber) {
		this.externalNumber = externalNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(String plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

}
