package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

public class Customer {

	private Map<String, Account> accounts;  //--converti en Map, VP=> Collection<Account> accounts;
	private int number;
	private String firstName;
	private String lastName;

	/**
	 * 
	 * @param number
	 * @param firstName
	 * @param lastName
	 */
	public Customer(Integer number, String firstName, String lastName) {
            this.number = number;
            this.firstName = firstName;
            this.lastName = lastName;
            this.accounts = new HashMap();
	}

	/**
	 * 
	 * @param number
	 */
	public Account getAccountByNumber(String number) {
            return this.accounts.get(number);	
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param rate
	 */
	public void addAccount(Account account) {
            accounts.put(account.getNumber(), account);
	}
        
        
        //Méthode toString()
        public String custToString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Customer N°");
        sb.append(this.number);
        sb.append("\n");
        sb.append("Name : ");
        sb.append(this.lastName);
        sb.append(" ");
        sb.append(this.firstName);
        sb.append("\n");
        sb.append("Accounts : ");
        for (Account acc : this.accounts.values()){
            sb.append(acc.accToString());
            Bank.nbAcc = Bank.nbAcc+1;
        }        
        sb.append("\n");
        

        return sb.toString();
    }

}