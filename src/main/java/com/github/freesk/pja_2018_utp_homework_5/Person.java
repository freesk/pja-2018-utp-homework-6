package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import com.github.freesk.pja_2018_utp_homework_5.SocialId;

public abstract class Person implements Comparable<Person> {

	public String firstName = "";
	public String lastName = "";
	public Date birthDate = null;
	public Country country = null;
	public SocialId socialId = null;
	
	private Comparator<Person> COMPARATOR = getComparator();
	
	Person(String firstName, String lastName, Date birthDate, Country country, SocialId socialId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.socialId = socialId;
	}
	
	public int compareTo(Person that) {
		return COMPARATOR.compare(this, that);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public Country getCountry() {
		return country;
	}
	
	private static Comparator<Person> getComparator() {
		Comparator <Person> comp = (p1, p2) -> {
			int r = p1.getFirstName().compareTo(p2.getFirstName());
		    if (r == 0) 
		    	r = p1.getLastName().compareTo(p2.getLastName());
		    if (!(p1.getBirthDate() == null || p2.getBirthDate() == null)) {
			    if (r == 0) 
			        r = p1.getBirthDate().compareTo(p2.getBirthDate());
		    }
		    if (!(p1.getCountry() == null || p2.getCountry() == null)) {
			    if (r == 0) 
			        r = p1.getCountry().compareTo(p2.getCountry());
		    }
		    return r;
		};
		return comp;
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(firstName, lastName, birthDate, country, socialId);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
        return (this.hashCode() == o.hashCode());
    }

}
