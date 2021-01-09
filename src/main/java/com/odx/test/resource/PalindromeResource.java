package com.odx.test.resource;

import com.odx.test.domain.Palindrome;

import java.lang.StringBuilder;

import org.springframework.stereotype.Service;

@Service
public class PalindromeResource {
	
	public static Palindrome identifyPalindrome(String input) {
		// Trim white space to account for palindromic sentences
		input = input.replaceAll("\\s+","");
		
		// Standardize to lower case
		input = input.toLowerCase();
		
		// Set initial palindrome to be the first character in the input
		String longestPalindrome = input.substring(0, 1);
		String potentialPalindrome = "";
		
		// Iterate over length of input
		for (int i = 0 ; i < input.length() ; i++) {
			// Iterate over input in reverse
			for (int j = input.length() ; j > i ; j--) {
				potentialPalindrome = input.substring(i, j);
				// Break inner loop if the current longest is greater in length than any future possibilities
				if (potentialPalindrome.length() <= longestPalindrome.length()){
					break;
				} // Compare the potential string to its reverse
				else if (potentialPalindrome.equals(reverse(potentialPalindrome))) {
					if (potentialPalindrome.length() > longestPalindrome.length()) {
						longestPalindrome = potentialPalindrome;
					}
				}
			}
		}
		return new Palindrome(longestPalindrome);
	}
	
	// Helper method to reverse strings
	private static String reverse(String input) {
		StringBuilder reversedInput = new StringBuilder();
        return reversedInput.append(input).reverse().toString();
	}
}