package com.Hibe2.DemoBank;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


public class App 
{
				
	public void addCustomer() {
		Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the following details to register...");
    	Account ac = new Account();
    	Customer c = new Customer();
    	
    	System.out.println("Name");
    	c.setName(sc.nextLine());
    	System.out.println("Age");
    	c.setAge(sc.nextInt());
    	System.out.println("Enter account details...");
    	
    	System.out.println("Account No.");
       	ac.setAccNumber(sc.nextInt());
       	System.out.println("Balance");
    	ac.setBalance(sc.nextFloat());
    	sc.nextLine();
    	System.out.println("Bank name");
    	String s = sc.nextLine();
    	ac.setBankName(s);     	
    	
    	ac.setCust(c);
    	
    	c.getAccounts().add(ac);
    	
Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Account.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();    
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.save(c);
        session.save(ac);
        
        
        session.getTransaction().commit();
        System.out.println("Congratulations! You have registered your account successfully!");
        session.close();
    	
    	
	}
	
	public void fetchBalance() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your account number");
		int d = sc.nextInt();
Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Account.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();    
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        
        Query q = session.createQuery("select balance from Account a where a.accNumber = :d");
        q.setParameter("d",d);
        Float bal = (Float)q.uniqueResult();
        if (bal == null) {
        	System.out.println("Sorry! Account not found...");
			return;
        }
        else
        System.out.println("Your balance is "+bal);    
        
        session.getTransaction().commit();
        session.close();
	}	
      
	
	
    public static void main( String[] args)throws Exception 
    {
    	Scanner sc = new Scanner(System.in);
    	App obj = new App();
    	
    	System.out.println("Enter 1 to add a customer or enter 2 to check balance");
    	int t = sc.nextInt();
    	if(t == 1)
    		obj.addCustomer();
    	else if(t == 2) 
    		obj.fetchBalance();
    	else {
    		System.out.println("Please enter a valid entry");
    		return;
    	}
    }
}
    	
    	
    	

   

