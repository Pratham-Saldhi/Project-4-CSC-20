/**
 * Pratham Saldhi
 * Project-4
 * Prof. Abida Mukarram
 * CSC-20
 * 
 * Creating a Main class to run
 * the overall project. It reads in the 
 * data for the Bank class to create a list of 
 * bank accounts, sorts them in different ways.
 * Can also deposit and withdraw amount from given account.
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// create a new bank called Wells Fargo
		Bank wellsFargo = new Bank("Wells Fargo");
		// populate the bank with bank account objects read from the file
		populateBankDataBase(wellsFargo);
		// make a copy of this unsorted bank account arraylist
		Bank copy = new Bank("Copy of WellsFargo");

		 wellsFargo.backup(copy);
		// make another copy of the unsorted wellsfargo bank
		Bank anotherCopy = new Bank("Another Copy of WellsFargo");
		 wellsFargo.backup(anotherCopy);
		// use bubble sort to sort the wells fargo bank
		// all sorts are based on account number
		int timesBubble = wellsFargo.bubbleSort();
		System.out.println(wellsFargo.toString());
		// print the number of swaps
		System.out.println("The number of swaps for bubble sort was " + timesBubble);
		// use selection sort to sort the copy of wells fargo
		int timesSelection = copy.selectionSort();
		System.out.println(copy.toString());
		// print the number of swaps for this sort
		System.out.println("The number of swaps for selection sort was " + timesSelection);

		// use the Java Collections sort by passing a AutoNamesCompare object

		anotherCopy.nameSort();
		System.out.println(anotherCopy.toString());
		// search for an existing account 1201
		searchAccount(wellsFargo);
		// search for a non existing account 1200
		searchAccount(copy);

		// test the withdraw and deposit methods
		int number = getAccountNumber();
		int found = wellsFargo.recursiveBinarySearch(number);// returns the index of the bank account in the array
		if (found >= 0) {
			// Test deposit
			System.out.println(wellsFargo.get(found).toString());
			wellsFargo.get(found).deposit(1000);
			System.out.println(wellsFargo.get(found).toString());
			
			// Test withdraw
//			System.out.println(wellsFargo.get(found).toString());
//			wellsFargo.get(found).withdraw(6009);
//			System.out.println(wellsFargo.get(found).toString());

		}
		if(found < 0) {
			System.out.println("Account does not exist");
		}

	}

	public static void populateBankDataBase(Bank b) throws FileNotFoundException {
		Scanner input = null;
		// read the bank account information line by line (there is one account per
		// line)
		input = new Scanner(new File("BankData.txt"));
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner in = new Scanner(line);
			String firstName = in.next();
			String lastName = in.next();
			int accountNumber = in.nextInt();
			double balance = in.nextDouble();
			// create a bank account object for each account
			BankAccount bankAccount = new BankAccount(firstName, lastName, balance, accountNumber);
			// add the bank account to the bank
			b.add(bankAccount);
		}
	}

	public static int getAccountNumber() {
		System.out.print("What is the account number ? ");
		Scanner console = new Scanner(System.in);
		return console.nextInt();
	}

	public static void searchAccount(Bank b) {
		int accountNumber = getAccountNumber();
		int num = b.recursiveBinarySearch(accountNumber);
		if (num >= 0)
			System.out.println(b.get(num).toString());
		else
			System.out.println("Account Does Not Exist");
	}

}