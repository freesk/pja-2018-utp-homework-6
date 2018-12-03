package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Date;

public class Student extends Person {

	StudentId studentId = null;
	
	public Student(String firstName, String lastName, Date birthDate, Country country, SocialId socialId, StudentId studentId) {
		super(firstName, lastName, birthDate, country, socialId);
		this.studentId = studentId;
	}
	
	// I don't think Student needs a different hashCode method.
	// The one which is in Person already already greatness 
	// sufficient uniqueness.

}
