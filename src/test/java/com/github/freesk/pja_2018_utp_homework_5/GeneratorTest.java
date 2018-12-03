package com.github.freesk.pja_2018_utp_homework_5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class GeneratorTest {

	public static Set<Department> departments = new HashSet<Department>();
	public static Set<Subject> subjects = new HashSet<Subject>();
	public static Set<Group> groups = new HashSet<Group>();
	
	@Test
	void generate() {
		Generator.generate(People.set, groups, departments, subjects);
		// every entity that belongs to the above sets is always unique because of Set 
		
		List<Subject> ss = new ArrayList<Subject>();
		
		ss.addAll(subjects);
		
		for (Subject s : ss) {
			Assert.assertNotNull(s.getName());
			Assert.assertNotNull(s.getDepartment());
			Assert.assertEquals(true, s.students.size() > 0);
		}
		
		Assert.assertEquals(120 + 10, People.set.size());
		
		// don't see a reason to test the generator itself actaully 
		Assert.assertEquals(true, true);
	}

}
