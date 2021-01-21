/**
 * Pratham Saldhi
 * Project-4
 * Prof. Abida Mukarram
 * CSC-20
 * 
 * Creating a BankAccount class that contains
 * the fundamental features of an account like balance, accountNumber etc.
 * It also contains deposit, compareTo and withdraw methods. 
 */
import java.util.*;
public class BankAccount implements Comparable<BankAccount>{
	// Minimum account balance
	public final double MINIMUM = 500.00;
	   private String firstName;
	   private String lastName;
	   private double balance;
	   private int accountNumber;
	   // Constructor
	   public BankAccount(String firstName, String lastName, double balance, int accountNumber) {
	       super();
	       this.firstName = firstName;
	       this.lastName = lastName;
	       this.balance = balance;
	       this.accountNumber = accountNumber;
	   }
	   /**Creating getters and setters for all the private fields*/
	   public String getFirstName() {
	       return firstName;
	   }

	   public void setFirstName(String firstName) {
	       this.firstName = firstName;
	   }

	   public String getLastName() {
	       return lastName;
	   }

	   public void setLastName(String lastName) {
	       this.lastName = lastName;
	   }

	   public double getBalance() {
	       return balance;
	   }

	   public void setBalance(double balance) {
	       this.balance = balance;
	   }

	   public int getAccountNumber() {
	       return accountNumber;
	   }

	   public void setAccountNumber(int accountNumber) {
	       this.accountNumber = accountNumber;
	   }

	   // returns a string with all the info.
	   public String toString() {

			String output = String.format("%10s%10s%12s%d%10s%10.2f", firstName, lastName, ": Account Number ",
					accountNumber, " Balance: ", balance);

			// return firstName + " "+ lastName+ ": Account Number "+accountNumber+ " Balance: "+balance;
			return output;
		}

	   /*
	    * Deposits the amount in the
	    * account, and throws InputMismatch Exception
	    * if amount is less than 0. 
	    */
	   public void deposit(double amount) {
		// if amount is negative throw InputMismatch Exception
		   if(amount < 0) {
			   throw new InputMismatchException("Cannot deposit negative amount");
		   }
		   balance = balance + amount;
	       
	   }
	/*
	 * implement this method to compare two bank account numbers, from this
	 * and the other. returns either 1, -1 or 0
	 */
	   public int compareTo(BankAccount bankAccountOther) {
	       String oName = bankAccountOther.getFirstName() + " " + bankAccountOther.getLastName();
	       String iName = this.firstName + " " + this.lastName;
	       int oNameAscii = 0;
	       int iNameAscii = 0;
	       for (int i = 0; i < oName.length(); i++) {
	           oNameAscii = oNameAscii + oName.charAt(i);
	       }
	       for (int i = 0; i < iName.length(); i++) {
	           iNameAscii = iNameAscii + iName.charAt(i);
	       }
	       if (oNameAscii > iNameAscii) {
	           return -1;
	       } else if (oNameAscii < iNameAscii) {
	           return 1;
	       } else
	           return 0;
	   }
	/*
	 * Withdraws the amount from the account
	 * if balance turns out to be less than minimum,
	 * throws InputMisMatchException.
	 */
	   public void withdraw(double amount) {
	       balance = balance - amount;
	       if(balance < MINIMUM) {
	    	   throw new InputMismatchException("balance under minimum");
	       }
	   }
	}