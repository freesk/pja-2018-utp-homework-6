package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.github.freesk.pja_2018_utp_homework_5.Teacher;

public class Department implements Comparable<Department> {
	public Set<Teacher> set = new HashSet<Teacher>();
	public String name = "";
	private Comparator<Department> COMPARATOR = getComparator();
	
	Department(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
	
	private static Comparator<Department> getComparator() {
		Comparator <Department> comp = (d1, d2) -> {
			int r = d1.getName().compareTo(d2.getName());
		    return r;
		};
		return comp;
	}
	
	public int compareTo(Department that) {
		return COMPARATOR.compare(this, that);
	}
}
