package com.github.freesk.pja_2018_utp_homework_5;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class People {
	public static Set<Person> set = new HashSet<Person>();
	
	// Sorry, not quite sure what you mean by "sorting instances based on Polish collation" 
	
	public static Set<Person> sortyByCountry(Country country) {
		return set.stream()
				.filter(p -> p.getCountry() == country)
				.collect(Collectors.toSet());
	}
}
