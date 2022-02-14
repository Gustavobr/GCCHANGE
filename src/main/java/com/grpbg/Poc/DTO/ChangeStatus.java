package com.grpbg.Poc.DTO;

/* Pojo (Bean)  -- Model Change */
public class ChangeStatus {

	/* Default Builder */
	public ChangeStatus() {

	}

	private String id;

	private String example;

	private String prfc; /* Example SUBMIT */

	private String rfc; /* Example APPROVE */

	private String simple; /* Example IMPLEMENTED */

	private String extensive; /* example GO */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getPrfc() {
		return prfc;
	}

	public void setPrfc(String prfc) {
		this.prfc = prfc;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}

	public String getExtensive() {
		return extensive;
	}

	public void setExtensive(String extensive) {
		this.extensive = extensive;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public String[] getDefaultFor() {
		return defaultFor;
	}

	public void setDefaultFor(String[] defaultFor) {
		this.defaultFor = defaultFor;
	}

	private boolean archive; /* Example false */

	private String[] defaultFor = new String[5];

}
