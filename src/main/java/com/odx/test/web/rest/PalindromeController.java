package com.odx.test.web.rest;

import com.odx.test.domain.Palindrome;
import com.odx.test.repository.PalindromeRepository;
import com.odx.test.resource.PalindromeResource;
import com.odx.test.web.rest.errors.PalindromeNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** 
 * REST controller for managing Palindromes.
 */
@RestController
public class PalindromeController {
	
	@Autowired
	private final PalindromeRepository palindromeRepository;
	
	public PalindromeController(PalindromeRepository palindromeRepository) {
		this.palindromeRepository = palindromeRepository;
	}
	
	// Get all Palindromes
	@GetMapping("/palindromes")
	public List<Palindrome> getAllPalindromes() {
		List<Palindrome> palindromes = palindromeRepository.findAll();
		return palindromes;
	}
	
	// Get a specific Palindrome by ID
	@GetMapping("/palindromes/{id}")
	public Palindrome findPalindrome(@PathVariable Long id) {
		return palindromeRepository.findById(id)
				.orElseThrow(() -> new PalindromeNotFoundException(id));
	}
	
	// Process and add a Palindrome
	@PostMapping("/palindromes")
	public Palindrome createPalindrome(@RequestBody String input) {
		Palindrome palindrome = PalindromeResource.identifyPalindrome(input);
		return palindromeRepository.save(palindrome);
	}
}