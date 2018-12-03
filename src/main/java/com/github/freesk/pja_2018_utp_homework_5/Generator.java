package com.github.freesk.pja_2018_utp_homework_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

public class Generator {
	
	private static final List<Country> COUNTRIES =
		    Collections.unmodifiableList(Arrays.asList(Country.values()));
	
	private static final List<AcademicDegree> DEGREES =
		    Collections.unmodifiableList(Arrays.asList(AcademicDegree.values()));
	
	private static Teacher getRandomTeacher(Set<Person> people) {
		List<Teacher> list = people.stream()
				.filter(p -> p instanceof Teacher)
				.map(p -> (Teacher) p)
				.collect(Collectors.toList());
		
		return list.get(Mixin.getRandomInt(0, list.size() - 1));
	}
	
	private static List<Student> getStudents(Set<Person> people) {
		return people.stream()
				.filter(p -> p instanceof Student)
				.map(p -> (Student) p)
				.collect(Collectors.toList());
	}
	
	public static void generate(
			Set<Person> people, 
			Set<Group> groups, 
			Set<Department> departments,
			Set<Subject> subjects) {
		
			int i = 0;
			
			Faker faker = new Faker();
			
			// create students
			for (i = 0; i < 120; i++) {
				String firstName = faker.name().firstName();
				String lastName = faker.name().lastName();
				Date birthDate = faker.date().birthday(18, 99);
				SocialId socId = new SocialId(faker.idNumber().valid());
				StudentId studId = new StudentId(faker.idNumber().valid());
				Country country = COUNTRIES.get(Mixin.getRandomInt(0, COUNTRIES.size() - 1));
				
				people.add(new Student(firstName, lastName, birthDate, country, socId, studId));
			}
			
			// create teachers
			for (i = 0; i < 10; i++) {
				String firstName = faker.name().firstName();
				String lastName = faker.name().lastName();
				Date birthDate = faker.date().birthday(18, 99);
				Date hireDate = faker.date().past(30 * 12 * 10, TimeUnit.DAYS);
				SocialId socId = new SocialId(faker.idNumber().valid());
				Country country = COUNTRIES.get(Mixin.getRandomInt(0, COUNTRIES.size() - 1));
				AcademicDegree degree = DEGREES.get(Mixin.getRandomInt(0, DEGREES.size() - 1));
				
				people.add(new Teacher(firstName, lastName, birthDate, country, socId, hireDate, degree));
			}
			
			Department d1 = new Department("department-1");	
			
			for (i = 0; i < Mixin.getRandomInt(3, 6); i++) {
				d1.set.add(getRandomTeacher(people));
			}
			
			Department d2 = new Department("department-2");
			
			for (i = 0; i < Mixin.getRandomInt(3, 6); i++) {
				d2.set.add(getRandomTeacher(people));
			}
			
			Department d3 = new Department("department-3");
			
			for (i = 0; i < Mixin.getRandomInt(3, 6); i++) {
				d3.set.add(getRandomTeacher(people));
			}
			
			departments.add(d1);
			departments.add(d2);
			departments.add(d3);
			
			List<Student> list = getStudents(people);
			
			// create groups
			for (i = 0; i < 12; i++) {
				String name = "group-" + (i + 1);
				Group g = new Group(name);
				
				for (int j = 0; j < 10; j++) 
					g.set.add(list.remove(0));
				
				groups.add(g);
			}
			
			list = getStudents(people);
			
			for (i = 0; i < 10; i++) {
				String name = "subject-" + (i + 1);
				List<Department> ds = new ArrayList<Department>();
				ds.addAll(departments);
				// get a random department 
				Department d = ds.get(Mixin.getRandomInt(0, ds.size() - 1));
				List<Teacher> ts = new ArrayList<Teacher>();
				ts.addAll(d.set);
				// get a random teacher from the department
				Teacher t = ts.get(Mixin.getRandomInt(0, ts.size() - 1));
				Subject s = new Subject(name, d, t);
				
				for (int j = 0; j < 12; j++) {
					s.students.add(list.remove(0));
				}
				
				subjects.add(s);
			}
		
		
	}
	
}
