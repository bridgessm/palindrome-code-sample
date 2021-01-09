package com.odx.test.repository;

import com.odx.test.domain.Palindrome;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PalindromeRepository extends JpaRepository<Palindrome, Long> {
	
}