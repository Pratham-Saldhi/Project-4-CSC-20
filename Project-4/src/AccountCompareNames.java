/**
 * Pratham Saldhi
 * Project-4
 * Prof. Abida Mukarram
 * CSC-20
 * 
 * Creating an AccountCompareNames class
 * that implements the compare method compares BankAccount
 * a and b by comparing names and returns 0 for 
 * same, a positive number if a is lexicographically greater than
 * b and a negative number if a is less than b
 */
import java.util.*;

public class AccountCompareNames implements Comparator<BankAccount> {

	// Implementing the compare method
	public int compare(BankAccount a, BankAccount b) {
		String aName = a.getFirstName() + " " + a.getLastName();
		String bName = b.getFirstName() + " " + b.getLastName();
		// int aNameAscii = 0;
		// int bNameAscii = 0;
		if (aName.equalsIgnoreCase(bName)) {
			return -1;
		}
		int d = Math.min(aName.length(), bName.length());
		for (int i = 0; i < d; i++) {
			if (aName.charAt(i) > bName.charAt(i)) {
				return 1;
			}
			if (a.getFirstName().charAt(i) < bName.charAt(i)) {
				return -1;
			}
		}
		return -1;

	}

}
