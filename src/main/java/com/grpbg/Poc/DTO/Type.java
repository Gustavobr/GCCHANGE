package com.grpbg.Poc.DTO;

public enum Type {

	operator("operador"), manager("manager");

	Type(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

}
