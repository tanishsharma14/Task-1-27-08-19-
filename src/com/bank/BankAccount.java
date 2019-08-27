package com.bank;

import java.util.*;

public class BankAccount {
	
	private int account_no;
	private String name;
	private int balance;
	private String account_type;
	
	
	public static int total_deposit=0;
	public static int total_withdrawl=0;
	
	public BankAccount(int account_no, String name, int balance,String account_type) {
		this.account_no = account_no;
		this.name = name;
		this.balance = balance;
		this.account_type = account_type;
	}


	public void showAccountDetails()
	{
		System.out.println("\tDetails:");
		System.out.println("Account Type:"+this.account_type+"\n"+"Account number:"+this.account_no+"\n"+"Accountholder name:"+this.name+"\n"+"Account balance:"+this.balance);
	}
	
	public void addMoney(int amount)
	{
		this.balance+=amount;
		total_deposit+=amount;
		System.out.println(amount+"rs added");
	}
	
	public void withdrawMoney(int amount)
	{
		if(this.balance-amount<0)
				System.out.println("Insufficient bakance");
		else
		{
			this.balance-=amount;
			total_withdrawl+=amount;
			System.out.println(amount+"rs withdrawed");
		}
	}
	
	public static void showAverageBalance(BankAccount...accounts)
	{
		int sum=0;
		for(BankAccount a:accounts)
		{
			sum+=a.balance;
		}
		
		System.out.println("Average balance of these "+accounts.length+" is "+sum/accounts.length);
	}
	public static void main(String args[])
	{
		BankAccount account1=new BankAccount(01,"Tanish",0,"Saving");
		BankAccount account2=new BankAccount(02,"Jay",0,"Saving");
		BankAccount account3=new BankAccount(03,"Vijay",0,"Current");
		
		
		System.out.println("-------------------Account 1--------------------------");
		account1.showAccountDetails();
		account1.addMoney(1000);			//money added
		account1.withdrawMoney(300);		//money withdraw
		account1.showAccountDetails();
		
		
		System.out.println("------------------Account2-------------------------------------");
		account2.showAccountDetails();
		account2.addMoney(2000);			//Money added
		account2.withdrawMoney(600);		//Money subtracted
		account2.showAccountDetails();
		
		
		System.out.println("----------------Account 3---------------------------------------");
		account3.showAccountDetails();
		account3.addMoney(3000);			//Money added
		account3.withdrawMoney(900);		//Money subtracted
		account3.showAccountDetails();
		
		System.out.println("---------------------Total----------------------------");
		System.out.println("Total money deposited is: "+total_deposit);
		System.out.println("Total money withdrawl is: "+total_withdrawl);
		
		
		System.out.println("-----------------------Average-------------------------------");
		showAverageBalance(account1,account2);
	}

}
