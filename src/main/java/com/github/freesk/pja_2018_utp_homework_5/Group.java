package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group implements Comparable<Group> {
	
	// to reduce complexity the name should always 
	// be unique e.g. 2018-pja-informatics-g10
	
	public String name = "";
	public Set<Student> set = new HashSet<Student>();
	private Comparator<Group> COMPARATOR = getComparator();
	
	Group(String name) {
		this.name = name;
	}
	
	public int compareTo(Group that) {
		return COMPARATOR.compare(this, that);
	}
	
	public String getName() {
		return name;
	}
	
	private static Comparator<Group> getComparator() {
		Comparator <Group> comp = (g1, g2) -> {
			int r = g1.getName().compareTo(g2.getName());
		    return r;
		};
		return comp;
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
        return (this.hashCode() == o.hashCode());
    }
}
