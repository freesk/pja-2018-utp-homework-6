package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Date;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class PersonTest {
	
	@Test
	void compare() {
		Date now = new Date();
		Student s1 = new Student("a", "a", now, Country.BRITISH, null, null);
		Student s2 = new Student("a", "a", now, Country.BRITISH, null, null);
		
		Assert.assertEquals(0, s1.compareTo(s2));
	
		s2 = new Student("a", "b", now, Country.BRITISH, null, null);
			
		Assert.assertEquals(-1, s1.compareTo(s2));
	}
	
	@Test
	void equals() {
		Date now = new Date();
		Student s1 = new Student("a", "a", now, Country.BRITISH, null, null);
		Student s2 = new Student("a", "a", now, Country.BRITISH, null, null);

		Assert.assertEquals(true, s1.equals(s2));
	
		s2 = new Student("a", "b", now, Country.BRITISH, null, null);

		Assert.assertEquals(false, s1.equals(s2));
	}
	
	
}
