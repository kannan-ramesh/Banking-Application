package com.kannanrameshrk.repository;

import java.util.ArrayList;
import java.util.List;

import com.kannanrameshrk.dto.Bank;

public class Repository {
	public static Repository repository=null;
	
	private Repository() {
		
	}
	
	public static List<Bank> customerList=new ArrayList<>();
	
	
	public static Repository getInstance() {
		if(repository==null) {
			repository=new Repository();
		}
		return repository;
	}

	public static List<Bank> getData() {
		return customerList;
	}
	
}
