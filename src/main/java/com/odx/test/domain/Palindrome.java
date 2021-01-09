package com.odx.test.domain;

import java.util.Objects;
import javax.persistence.*;

/**
 * A Palindrome entity definition.
 */

@Entity
public class Palindrome {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column( columnDefinition = "varchar(max)" )
	private String palindrome;
	
	// Empty constructor
	public Palindrome() {}
	
	// Basic constructor
	public Palindrome(String palindrome) {
		this.palindrome = palindrome;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Palindrome id(Long id) {
		this.id = id;
		return this;
	}
	
	public String getPalindrome() {
		return this.palindrome;
	}
	
	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}
	
	public Palindrome palindrome(String palindrome) {
		this.palindrome = palindrome;
		return this;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Palindrome)) {
            return false;
        }
        return id != null && id.equals(((Palindrome) o).id);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(this.id, this.palindrome);
    }
    
    @Override
    public String toString() {
    	return "Palindrome{" +
    		"id=" + getId() +
    		", palindrome='" + getPalindrome() + "'" +
    		"}";
    }
}