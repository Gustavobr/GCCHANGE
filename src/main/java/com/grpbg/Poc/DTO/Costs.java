package com.grpbg.Poc.DTO;

public class Costs {
	
	private double number;
	
	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public String getCurrencyPrefix() {
		return currencyPrefix;
	}

	public void setCurrencyPrefix(String currencyPrefix) {
		this.currencyPrefix = currencyPrefix;
	}

	public String getCurrencySuffix() {
		return currencySuffix;
	}

	public void setCurrencySuffix(String currencySuffix) {
		this.currencySuffix = currencySuffix;
	}

	private String currencyPrefix;
	
	private String currencySuffix;

}
