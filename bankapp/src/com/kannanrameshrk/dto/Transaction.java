package com.kannanrameshrk.dto;

public class Transaction {
	private int tId;
	private String tranType;
	private double amount;
	private double balance;
	
	
	
	public Transaction(int tId, String tranType, double amount, double balance) {
		this.tId=tId;
		this.tranType=tranType;
		this.amount=amount;
		this.balance=balance;
	}
	
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
