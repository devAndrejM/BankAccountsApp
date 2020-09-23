package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        //Read a CSV file then create new accounts based on that data
        String file = "E:\\BankAccountApp\\NewBankAccounts.csv" ;
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
            System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);

            if(accountType.equals("Savings")){
                System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name,sSN,initDeposit));
            }
            else if(accountType.equals("Checking")){
                System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name,sSN,initDeposit));
            }
            else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for(Account acc: accounts){
            System.out.println("\n***********************\n");
            acc.showInfo();
        }
    }
}
