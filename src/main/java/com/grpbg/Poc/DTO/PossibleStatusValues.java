package com.grpbg.Poc.DTO;

public class PossibleStatusValues {

	private NotStarting notStarting;
	private Starting starting;
	private Implementing implementing;
	private Closing closing;

	private Object[] possibleStatusValues = { notStarting, starting, implementing, closing };

	public NotStarting getNotStarting() {
		return notStarting;
	}

	public void setNotStarting(NotStarting notStarting) {
		this.notStarting = notStarting;
	}

	public Starting getStarting() {
		return starting;
	}

	public void setStarting(Starting starting) {
		this.starting = starting;
	}

	public Implementing getImplementing() {
		return implementing;
	}

	public void setImplementing(Implementing implementing) {
		this.implementing = implementing;
	}

	public Closing getClosing() {
		return closing;
	}

	public void setClosing(Closing closing) {
		this.closing = closing;
	}

	public Object[] getPossibleStatusValues() {
		return possibleStatusValues;
	}

	public void setPossibleStatusValues(Object[] possibleStatusValues) {
		this.possibleStatusValues = possibleStatusValues;
	}

}
