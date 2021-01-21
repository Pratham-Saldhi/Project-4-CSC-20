/**
 * Pratham Saldhi
 * Project-4
 * Prof. Abida Mukarram
 * CSC-20
 * 
 * Creating a Bank class that contains an arraylist
 * of various bank accounts. The bank class has many methods like 
 * add, get toString etc. It also contains selection and bubble sort
 * and a recursiveBinarySearch. 
 */
import java.util.*;

public class Bank implements Comparator {
	private String bankName = "";
	// Arraylist for bank accounts
	ArrayList<BankAccount> bank = null;
	// Constructor
	public Bank(String bankName) {
		this.bankName = bankName;
		bank = new ArrayList<BankAccount>();
	}
	// Add account
	public void add(BankAccount a) {
		bank.add(a);
	}
	// Implementing a BubbleSort Algorithm
	public int bubbleSort() {
		BankAccount temp;
		int swapCount = 0;
		for (int i = 0; i < bank.size(); i++) {
			for (int j = 1; j < bank.size() - i; j++) {
				if (bank.get(j - 1).getAccountNumber() > bank.get(j).getAccountNumber()) {
					// swap elements
					temp = bank.get(j - 1);
					bank.set(j - 1, bank.get(j));
					bank.set(j, temp);
					swapCount++;
				}
			}
		}
		return swapCount;
	}
	// Swap two bank accounts
	public void swapEm(int i, int j) {
		BankAccount temp1 = bank.get(i);
		BankAccount temp2 = bank.get(j);
		bank.remove(i);
		bank.add(i, temp2);
		bank.remove(j);
		bank.add(j, temp1);
	}
	// Implementing a selection sort algo.
	public int selectionSort() {
		int times = 0;
		int i = 0;
		int number = bank.size();// Number of bank accounts
		boolean swap = true;
		int minValue = 0, minIndex = 0;
		while (i < number - 1 && swap) {
			minIndex = i;
			swap = false;
			minValue = bank.get(i).getAccountNumber();
			for (int j = i + 1; j < number; j++) {
				if (bank.get(j).getAccountNumber() < minValue) {
					swap = true;
					minIndex = j;
					minValue = bank.get(j).getAccountNumber();
				}
			}
			if (swap) {
				swapEm(i, minIndex);
				times++;
			}
			i++;
		}
		return times;
	}
	// A toString method
	public String toString() {
		String output = "\n" + bankName + "\n";
		for (int i = 0; i < bank.size(); i++)
			output = output + bank.get(i).toString() + "\n";
		return output;
	}
	/*
	 * A recursiveBinarySearch method that 
	 * searches the given element in O(log(n))
	 * returns index of the element and -1 
	 * if not found.
	 */
	public int recursiveBinarySearch(int accountNumber, int first, int last) {
		if (first > last)
			return -1;
		int middle = (first + last) / 2;
		if (accountNumber == bank.get(middle).getAccountNumber())
			return middle;
		else if (accountNumber > bank.get(middle).getAccountNumber())
			return recursiveBinarySearch(accountNumber, middle + 1, last);
		else
			return recursiveBinarySearch(accountNumber, first, last - 1);
	}
	// RecursiveBinarySearch available to the user.
	public int recursiveBinarySearch(int accountNumber) {

		return recursiveBinarySearch(accountNumber, 0, bank.size() - 1);

	}
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	// Sorting the bank accounts by the names of the holder
	public void nameSort() {
		Comparator<BankAccount> cmp = new AccountCompareNames();
		Collections.sort(bank, cmp);
	}

	// returns BankAccount at index i
	public BankAccount get(int i) {
		return bank.get(i);
	}
	// returns the arrayList
	private ArrayList<BankAccount> getAccounts() {
		return bank;
	}
	/*
	 * Creating a back up method to copy all the 
	 * elements in the given Bank.
	 */
	public void backup(Bank other) {
		for (int i = 0; i < bank.size(); i++)
			other.add(bank.get(i));
		 Collections.copy(bank,other.getAccounts());
	}
	
}
