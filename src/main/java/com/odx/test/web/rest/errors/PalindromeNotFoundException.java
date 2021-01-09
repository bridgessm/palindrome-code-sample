package com.odx.test.web.rest.errors;

public class PalindromeNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;

public PalindromeNotFoundException(Long id) {
    super("Could not find Palindrome of ID: " + id);
  }
}