package com.grpbg.Poc.DTO;

/* POJO class */
public class TaskDTO {

	public String solicitante;

	public String link_task;

	public String descricao;

	public String listFiles;

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getLink_task() {
		return link_task;
	}

	public void setLink_task(String link_task) {
		this.link_task = link_task;
	}

	public String getDescricao() {
		return descricao;
	}

	public TaskDTO() {

	}

	public TaskDTO(String solicitante, String link_task, String descricao, String listFiles, String iscausedby) {
		super();
		this.solicitante = solicitante;
		this.link_task = link_task;
		this.descricao = descricao;
		this.listFiles = listFiles;
		this.iscausedby = iscausedby;
	}

	public String getListFiles() {
		return listFiles;
	}

	public void setListFiles(String listFiles) {
		this.listFiles = listFiles;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIscausedby() {
		return iscausedby;
	}

	public void setIscausedby(String iscausedby) {
		this.iscausedby = iscausedby;
	}

	public String iscausedby;

}
