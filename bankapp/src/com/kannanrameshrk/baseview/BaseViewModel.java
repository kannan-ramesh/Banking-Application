package com.kannanrameshrk.baseview;

import java.util.List;

import com.kannanrameshrk.dto.Customer;
import com.kannanrameshrk.dto.Transaction;
import com.kannanrameshrk.repository.Repository;

class BaseViewModel {
	public  BaseView baseView;
	
	public BaseViewModel(BaseView baseView) {
		this.baseView=baseView;
	}

	public void customerInitial() {
		//1.ZohoMail12 2.BAnking12 3.CAmpus12 4.JAva11
		Repository.customerList.add(new Customer(11,11011,"Kumar",10000,"ApipNbjm23"));
		Repository.customerList.add(new Customer(12,11012,"Madhu",20000,"CBoljoh23"));
		Repository.customerList.add(new Customer(13,11013,"Rahual",30000,"DBnqvt23"));
		Repository.customerList.add(new Customer(14,11014,"Robin",40000,"KBwb22"));
	}

	public List<Customer> showCustomerData() {
		return Repository.getData();
	}

	public void addCus(Customer bank) {
		Repository.customerList.add(bank);
		System.out.println("Customer Added successfully...");
	}

	public List<Transaction> getStatement(String name, int accNo) {
		List<Customer> data=Repository.customerList;
		
		for(Customer s:data) {
			if(s.getAccountNo()==accNo && s.getName().equals(name)) {
				return s.tranData;
			}
		}
		return null;
	}
}