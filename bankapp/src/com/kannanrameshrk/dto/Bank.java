package com.kannanrameshrk.dto;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	public static int id=11;
	public static int acc=11011;
	private int tranId=1;
	private int custId=id;
	private int accountNo=acc;
	private String name;
	private double balance;
	private String password;
	private String reTypePassword;
	public List<Transaction> tranData;
	
	public Bank(int cusId, int accountNo, String name, double balance, String password) {
		this.custId=cusId;
		id++;
		this.accountNo=accountNo;
		acc++;
		this.name=name;
		this.balance=balance;
		this.password=password;
		tranData=new ArrayList<>();
		Transaction tran=new Transaction(tranId++,"Opening",balance,balance);
		tranData.add(tran);
	}
	public Bank(String name, String password, double balance) {
		this.custId=id++;
		this.accountNo=acc++;
		this.name=name;
		this.balance=balance;
		this.password=password;
		tranData=new ArrayList<>();
		Transaction tran=new Transaction(tranId++,"Opening",balance,balance);
		tranData.add(tran);
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Bank.id = id;
	}
	public static int getAcc() {
		return acc;
	}
	public static void setAcc(int acc) {
		Bank.acc = acc;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReTypePassword() {
		return reTypePassword;
	}
	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}	
}