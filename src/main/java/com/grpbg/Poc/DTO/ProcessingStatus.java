package com.grpbg.Poc.DTO;

public enum ProcessingStatus {
	prfc("prfc"), rfc("rfc"), rejected("rejected"), extensive("extensive"), notStarted("notStarted"),
	extensive_inProgress("extensive_inProgress"), extensive_done("extensive_done"),
	extensive_evaluating("extensive_evaluating"), extensive_evaluated("extensive_evaluated"),
	extensive_closed("extensive_closed"), extensive_nogo("extensive_nogo"), extensive_cancelled("extensive_cancelled"),
	simple_notStarted("simple_notStarted"), simple_inProgress("simple_inProgress"), simple_done("simple_done"),
	simple_closed("simple_closed");

	private String status;

	ProcessingStatus(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
