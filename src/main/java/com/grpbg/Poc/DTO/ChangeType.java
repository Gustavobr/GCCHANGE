package com.grpbg.Poc.DTO;

public enum ChangeType {
	requisição_simples("Requisicação Simples"), requisicao_complexa("Requisição Complexa"), change_cab("Change-CAB"),
	change_ecab("Change-ECAB"), change_catalogo("Change de Catálogo");

	ChangeType(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

	/*
	 * @Override public String toString() { return text; }
	 */
}
