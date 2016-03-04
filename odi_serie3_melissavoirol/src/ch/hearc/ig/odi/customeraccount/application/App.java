package ch.hearc.ig.odi.customeraccount.application;

import ch.hearc.ig.odi.customeraccount.business.*;

/**
 *
 * @author stephane.grangier
 */
public class App {

    public static void main(String[] args) {

        new App().run();
    }

    private void run() {

        //Création de la banque
        System.out.println("---Création de la banque---");
        Bank bcbe = new Bank(1,"Banque Cantonale Bernoise SA");
        
        //Création d'un client
        System.out.println("---Création d''un client---");
        bcbe.addCustomer(1, "Albert", "Le Vert");

        //Création des comptes du client
        System.out.println("---Création des comptes du client---");
        bcbe.addAccount("1.1", "Compte courant", 0.5, bcbe.getCustomerByNumber(1));
        bcbe.addAccount("1.2", "Compte epargne", 1.5, bcbe.getCustomerByNumber(1));
        bcbe.addAccount("1.3", "Compte prevoyance", 2, bcbe.getCustomerByNumber(1));

        //Créditer les comptes du client
        System.out.println("---Créditer les comptes du client---");
        bcbe.getAccountByNumber("1.1").credit(10000);
        bcbe.getAccountByNumber("1.2").credit(20000);
        bcbe.getAccountByNumber("1.3").credit(30000);

        //Débiter les comptes du client
        System.out.println("---Débiter les comptes du client---");

        try {
            bcbe.getAccountByNumber("1.1").debit(5000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        try {
            bcbe.getAccountByNumber("1.2").debit(10000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        try {
            bcbe.getAccountByNumber("1.3").debit(100000);
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        //Transfert entre comptes 1->2 du client
        System.out.println("Transfert entre comptes 1->2 du client");

        try {
            Account.transfer(5000, bcbe.getAccountByNumber("1.1"), bcbe.getAccountByNumber("1.2"));
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }

        //Transfert entre comptes 2->3 du client (solde insuf) --> erreur
        System.out.println("Transfert entre comptes 2->3 du client (solde insuf) --> erreur");
        
        try {
            Account.transfer(20000, bcbe.getAccountByNumber("1.2"), bcbe.getAccountByNumber("1.3"));
        } catch (IllegalStateException e) {
            System.out.println("Solde insuffisant sur le compte pour effectuer cette opération");
        }
        
        //---------------------------------------------------------------------------------------
        //TEST
        //---------------------------------------------------------------------------------------
        
        //Création d'un client
        System.out.println("---Création d''un client TEST---");
        bcbe.addCustomer(2, "TEST", "ONE");
        
        //Création des comptes du client
        System.out.println("---Création des comptes du client TEST---");
        bcbe.addAccount("2.1", "Compte courant", 0.5, bcbe.getCustomerByNumber(2));
        Account acc = new Account("2.2", "Compte epargne", 1.5, bcbe.getCustomerByNumber(2));
        bcbe.getCustomerByNumber(2).addAccount(acc);
        
        //Créditer les comptes du client
        System.out.println("---Créditer les comptes du client TEST---");
        bcbe.getAccountByNumber("2.1").credit(10000);
        bcbe.getCustomerByNumber(2).getAccountByNumber("2.2").credit(20000);
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(bcbe.accountToString());
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(bcbe.allToString());
    }

}
