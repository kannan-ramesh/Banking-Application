package com.kannanrameshrk.baseview;

import java.util.List;
import java.util.Scanner;

import com.kannanrameshrk.dto.Customer;
import com.kannanrameshrk.dto.Transaction;
import com.kannanrameshrk.repository.Repository;

public class BaseView {
	public static BaseViewModel baseViewModel;
	public static Scanner input=new Scanner(System.in);
	
	public BaseView() {
		baseViewModel=new BaseViewModel(this);
	}

	public void init() {
		baseViewModel.customerInitial();
		start();
	}

	private void start() {
		
		while(true) {
			System.out.println("1.show Customers");
			System.out.println("2.AddCustomers");
			System.out.println("3.Operations");
			System.out.println("4.Top n Customer");
			System.out.println("5.Exit");
			
			System.out.println("Enter Your Choice:");
			int choice=input.nextInt();
			
			switch(choice) {
			case 1:{
				List<Customer> data=baseViewModel.showCustomerData();
				
				System.out.println("CusId   AccountNo   Name   Balance   EncryptedPwd");
				for(Customer s:data) {
					System.out.println(s.getCustId()+"      "+s.getAccountNo()+"      "+s.getName()+"    "+s.getBalance()+"  "+s.getPassword());
				}
				break;
			}
			case 2:{
				System.out.println("\t\t Add Customer");
				System.out.println("\t\t*************");
				
				System.out.println("Enter Name:");
				String name=input.next();
				System.out.println("Enter Password:");
				String password=input.next();
				boolean check=checkPassword(password);
				if(!check) {
					System.out.println("Your Password Length is Min 6 Size,Caps and Small and Number is Atleast 2 Character..");
					System.out.println("Try Again..");
					break;
				}
				String encryptPassword=encrypt(password);
				System.out.println("Enter ReType Password:");
				String reTypePassword=input.next();
				
				if(!password.equals(reTypePassword)) {
					System.out.println("Your Re TypePassword is wrong..");
					break;
				}
				double balance=10000;
				Customer bank=new Customer(name,encryptPassword,balance);
				baseViewModel.addCus(bank);
				break;
			}
			case 3:{
				System.out.println("\t\tBank Operation");
				System.out.println("\t\t*************");
				
				System.out.println("Enter Your User ID:");
				int uID=input.nextInt();
				System.out.println("Enter Your Password:");
				String uPass=input.next();
				String encryptPassword=encrypt(uPass);
				
				Customer user=checkUser(uID,encryptPassword);
				if(user!=null){
					calOperation(user);
				}else {
					System.out.println("Please Check Your User ID and Password..");
				}
				System.out.println();
				
				break;
			}
			case 4:{
				System.out.println("\t\tTop N Customer");
				System.out.println("\t\t************");
				
				List<Customer> data=Repository.getData();
				List<Customer> arr=data.stream().sorted((a,b)->(int)b.getBalance()-(int)a.getBalance()).toList();
				
				System.out.println("CusId   AccountNo   Name   Balance   EncryptedPwd");
				System.out.println("--------------------------------------------------");
				for(Customer s:arr) {
					System.out.println(s.getCustId()+"      "+s.getAccountNo()+"      "+s.getName()+"    "+s.getBalance()+"  "+s.getPassword());
				}
				System.out.println("-----------------------------------------------------");
				break;
			}
			case 5:{
				System.out.println("Exit Application...");
				return;
			}
			default:{
				System.out.println("Invalid Choice Try Again...");
				break;
			}
			}
		}
	}
	
	private Customer checkUser(int id, String uPass) {
		List<Customer> user= Repository.getData();
		
		for(Customer i:user) {
			if( i.getCustId()== id && i.getPassword().equals(uPass) ) {
				return i;
			} 
		}
		return null;
	}

	private void calOperation(Customer user) {
		while(true) {
			System.out.println();
			System.out.println("1.ATM WithDraw");
			System.out.println("2.Cash Deposit");
			System.out.println("3.Account Transfer");
			System.out.println("4.Statement");
			System.out.println("5.Exit");
			
			System.out.println("Enter Your Choice:");
			int opt=input.nextInt();
			
			switch(opt) {
				case 1:{
					System.out.println("\t\tATM WithDraw");
					System.out.println("\t\t**********");
					
					System.out.println("Enter Your Password:");
					String uPass=input.next();
					String encryptPassword=encrypt(uPass);
					System.out.println("Enter Withdraw Amount:");
					double getAmount=input.nextDouble();
					
					if(user.getBalance()<=1000) {
						System.out.println("Your Amount is Low Min Balance in Bank 1000 Rs");
						System.out.println();
						return;
					}else if(getAmount>user.getBalance()) {
						System.out.println("Low Balance Your Account...");
					}else {
						if(!user.getPassword().equals(encryptPassword)) {
							System.out.println("Your Password is Wrong...");
						}else {
							double remain=user.getBalance() - getAmount;
							user.setBalance(remain);
							Transaction tran=new Transaction(user.getTranId(),"ATMWithdrawal",getAmount,remain);
							user.tranData.add(tran);
							System.out.println("ATM WithDraw Successfully");
							System.out.println();
						}
					}
					System.out.println();
					break;
				}
				case 2:{
					System.out.println("\t\t Cash Deposit");
					System.out.println("\t\t*************");
					
					System.out.println("Enter Deposit Amount:");
					double dpAmount=input.nextDouble();
					System.out.println("Enter Your Password:");
					String uPass=input.next();
					String encryptPassword=encrypt(uPass);
					
					if(!user.getPassword().equals(encryptPassword)){
						System.out.println("Your Password is Wrong Check..");
					}else {
						double bal=user.getBalance();
						user.setBalance(dpAmount+bal);
						Transaction tran=new Transaction(user.getTranId(),"CashDeposit",dpAmount,user.getBalance());
						user.tranData.add(tran);
						System.out.println("Cash Deposit Successfully..");
						System.out.println();
					}
					break;
				}
				case 3:{
					System.out.println("\t\tAccount Transfer");
					System.out.println("\t\t ***********");
					
					System.out.println("Enter Oppsite Person Accno:");
					int opAccNo=input.nextInt();
					
					Customer opData=checkUser(opAccNo);
					
					if(opData==null) {
						System.out.println("Opposite User not Found");
						return;
					}
					
					System.out.println("Enter Transfer Amount:");
					double tranAmount=input.nextDouble();
					System.out.println("Enter Your Password:");
					String uPass=input.next();
					String encryptPassword=encrypt(uPass);
					
					if(!user.getPassword().equals(encryptPassword)) {
						System.out.println("Your Password is Wrong...");
					}else {
						if(user.getBalance()<tranAmount) {
							System.out.println("Low Amount Your Account..");
						}else {
							double remain=user.getBalance()-tranAmount;
							user.setBalance(remain);
							opData.setBalance(opData.getBalance()+tranAmount);
							
							Transaction tran=new Transaction(user.getTranId(),"Transfer To "+ opAccNo,tranAmount,user.getBalance());
							user.tranData.add(tran);
							Transaction opTran=new Transaction(user.getTranId(),"Transfer From "+ user.getAccountNo(),tranAmount,opData.getBalance());
							opData.tranData.add(opTran);
							System.out.println("Account Transfer Successfully");
							System.out.println();
						}
					}
					break;
				}
				case 4:{
					System.out.println("\t\tAccount Statement");
					System.out.println("\t\t******************");
					System.out.println("ID - "+user.getCustId());
					System.out.println("Name - "+user.getName());
					System.out.println("Account No - "+user.getAccountNo());
					System.out.println();
						
						System.out.println("---------------------------------------------");
						System.out.println(" TransId    TransType     Amount    Balance");
						System.out.println("---------------------------------------------");
						for(Transaction s:user.tranData) {
							System.out.println(s.gettId()+"         "+s.getTranType()+"   "+s.getAmount()+"    "+s.getBalance());
						}
						System.out.println("---------------------------------------------");
					break;
				}
				case 5:{
					return;
				}
				default:{
					System.out.println("Invalid Pption Please Check..");
					break;
				}
			}
		}
	}

	private Customer checkUser(int accNo) {
		List<Customer> data=Repository.getData();
		
		for(Customer i:data) {
			if(i.getAccountNo()==accNo) {
				return i;
			}
		}
		return null;
	}

	private String encrypt(String pwd) {
		 StringBuilder sb = new StringBuilder();

		    for (int i = 0; i < pwd.length(); i++) {
		        char c = pwd.charAt(i);
		        char encryptedChar;

		        if (Character.isUpperCase(c)) {
		            // Wrap around if 'Z' is reached
		            encryptedChar = (char) (((c - 'A' + 1) % 26) + 'A');
		        } else if (Character.isLowerCase(c)) {
		            // Wrap around if 'z' is reached
		            encryptedChar = (char) (((c - 'a' + 1) % 26) + 'a');
		        } else if (Character.isDigit(c)) {
		            // Wrap around if '9' is reached
		            encryptedChar = (char) (((c - '0' + 1) % 10) + '0');
		        } else {
		            // Leave special characters as-is
		            encryptedChar = c;
		        }
		        sb.append(encryptedChar);
		    }
		    return sb.toString();
	}

	private boolean checkPassword(String pwd) {
		if(pwd.length()<6) {
			return false;
		}
		int upper=0,lower=0,num=0;
		
		for(int i=0;i<pwd.length();i++) {
			if(Character.isUpperCase(pwd.charAt(i))) {
				upper++;
			}else if(Character.isLowerCase(pwd.charAt(i))) {
				lower++;
			}else if(Character.isDigit(pwd.charAt(i))) {
				num++;
			}
		}
		return (upper>=2 && lower>=2 && num>=2);		
	}
}