package com.github.freesk.pja_2018_utp_homework_5;

import java.util.HashSet;
import java.util.Set;

public class Main {

	// Since I use Set to store all the entities and the method equals is redefined in every
	// entity, there is no reason to create "classes storing extensions".
	// The point is, all possible duplicates (if any) will be ignored anyway.
	// The class People can server as a service and filter by Country.
	
	public static Set<Department> departments = new HashSet<Department>();
	public static Set<Subject> subjects = new HashSet<Subject>();
	public static Set<Group> groups = new HashSet<Group>();
	
	public static void main(String[] args) {
		
		// To start make sense, I think, the program must contain a mapping class 
		// that can create references between groups, subjects, teachers and departments
		// e.g. a class Tutorial that can hold time, group, subject, teacher attributes. 
		// But due to the suggested data structure it will create a lot of inconsistency
		// and redundancy. 
		// Also, the requirement does not specify such class, only "classes storing extensions" which 
		// is quite ambiguous
		
		Generator.generate(People.set, groups, departments, subjects);
		
	}

}
