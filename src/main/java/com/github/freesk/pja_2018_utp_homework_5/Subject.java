package com.github.freesk.pja_2018_utp_homework_5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Subject implements Comparable<Subject> {
	// Actually, I don't think that the Teacher and
	// a set of Students belong here. 
	public String name = "";
	public Department department = null;
	public Teacher teacher = null;
	public Set<Student> students = new HashSet<Student>();
	
	private Comparator<Subject> COMPARATOR = getComparator();
	
	Subject(String name, Department department, Teacher teacher) {
		this.name = name;
		this.department = department;
		this.teacher = teacher;
	}
	
	@Override 
	public int hashCode() {
		// these three should be enough
		return Objects.hash(name, department, teacher);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
        return (this.hashCode() == o.hashCode());
    }
	
	public String getName() {
		return name;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	private static Comparator<Subject> getComparator() {
		Comparator <Subject> comp = (s1, s2) -> {
			int r = s1.getName().compareTo(s2.getName());
			if (!(s1.getDepartment() == null || s2.getDepartment() == null)) {
				if (r == 0) 
			    	r = s1.getDepartment().compareTo(s2.getDepartment());
			}
			if (!(s1.getTeacher() == null || s2.getTeacher() == null)) {
			    if (r == 0) 
			        r = s1.getTeacher().compareTo(s2.getTeacher());	
			}
		    return r;
		};
		return comp;
	}
	
	public int compareTo(Subject that) {
		return COMPARATOR.compare(this, that);
	}
}
