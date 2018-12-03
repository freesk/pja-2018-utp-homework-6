package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Date;

public class Teacher extends Person {

	AcademicDegree academicDegree = null;
	Date hireDate = null;
	
	public Teacher(String firstName, String lastName, Date birthDate, Country country, SocialId socialId, Date hireDate, AcademicDegree academicDegree) {
		super(firstName, lastName, birthDate, country, socialId);
		this.hireDate = hireDate;
		this.academicDegree = academicDegree;
	}
	
	// See comment in Student.java.
	// Same applies here.

	// We might redefine compareTo here so the teachers can be 
	// sorted by hireDate and academicDegree 
	// but I don't see such necessity
}
