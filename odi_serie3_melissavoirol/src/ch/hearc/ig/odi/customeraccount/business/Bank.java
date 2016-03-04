/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.business;

import java.util.HashMap;

/**
 *
 * @author steven.habegger
 */
public class Bank {
    private int number;
    private String name;
    private HashMap<String, Account> accounts;
    private HashMap<Integer, Customer> customers;
    public static int nbAcc;

    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
        this.accounts = new HashMap<String, Account>();
        this.customers = new HashMap<Integer, Customer>();
    }
    
    public Account getAccountByNumber(String number){
        return this.accounts.get(number);
    }
    
    public Customer getCustomerByNumber(int number){
        return this.customers.get(number);
    }
    
    public void addCustomer(int number, String fn, String ln){
        Customer cust = new Customer(number, fn, ln);
        customers.put(number, cust);
    }
    
    public void addAccount(String number, String name, double rate, Customer cust){
       Account account = new Account(number, name, rate,cust);
       accounts.put(number, account);
       cust.addAccount(account);
    }
    
    //Méthode toString()
    
    public String accountToString() {
        int nb = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("Bank N°");
        sb.append(this.number);
        sb.append("\n");
        sb.append("Name : ");
        sb.append(this.name);
        sb.append("\n");
        sb.append("Accounts : ");
        for (Account acc : this.accounts.values()){
            sb.append(acc.accToString());
            nb = nb+1;
        }        
        sb.append("\n");
        sb.append("Nombre de compte dans la banque : ");
        sb.append(nb);
        sb.append("\n");
        
        return sb.toString();
    }
    
    public String allToString() {
        Bank.nbAcc = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("Bank N°");
        sb.append(this.number);
        sb.append("\n");
        sb.append("Name : ");
        sb.append(this.name);
        sb.append("\n");
        sb.append("Accounts : ");
        for (Customer cust : this.customers.values()){
            sb.append(cust.custToString());
        }        
        sb.append("\n");
        sb.append("Nombre de compte dans la banque : ");
        sb.append(Bank.nbAcc);
        sb.append("\n");
        
        return sb.toString();
    }
}
