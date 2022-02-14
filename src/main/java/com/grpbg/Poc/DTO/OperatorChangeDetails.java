package com.grpbg.Poc.DTO;

// Pojo - Model Change 
public class OperatorChangeDetails {

	private String id;
	private String number;
	private String briefDescription;
	private Requester requester;
	private boolean archived;
	private ChangeType type;
	private String requestDate; /*= (String) LocalDateTime.now();*/
	private String creationDate;
	private String lastModificationDate;
	private boolean emergencyChange;
	private ProcessingStatus status;
	private Costs costs;
	private String[] possibleActions = {"submit","reject"};
	private Cordinator cordinator;
	private Phases phases;
	private Rfc rfc;
	private Progress progress;
	private Evaluation evaluation;
	private Simple simpleChange;
	private String externalNumber;
	
	
	
	
}
