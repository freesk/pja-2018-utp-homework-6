package com.github.freesk.pja_2018_utp_homework_5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PeopleTest {

	@Test
	void sortyByCountry() {
		
		Date now = new Date();
		
		Student s1 = new Student("TEST", "TEST", now, Country.BRITISH, null, null);
		Student s2 = new Student("TEST", "TEST", now, Country.BRITISH, null, null);
		Teacher t1 = new Teacher("TEST", "TEST", now, Country.POLISH, null, null, AcademicDegree.ENGINEER);
		
		People.set.add(s1);
		People.set.add(s2);
		People.set.add(t1);
		
		Set<Person> set = People.sortyByCountry(Country.POLISH);
		
		Assert.assertEquals(1, set.size());
		Assert.assertEquals(t1, set.toArray()[0]);
	}

}
