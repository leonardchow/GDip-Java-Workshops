package com.leonardchow.students;

import java.util.ArrayList;
import java.util.Collections;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("a01015g", "Peter", "John", 1000.0, 10.0);
		Student s2 = new Student("a01012f", "Simon", "Sim", 1300.0, 10.0);
		Student s3 = new Student("a01011z", "Brad", "Chan", 1200.0, 10.0);
		Student s4 = new Student("a01020a", "King", "Tut", 1100.0, 10.0);
		Student s5 = new Student("a01111g", "Hayley", "Richards", 900.0, 10.0);

		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		System.out.println("Added order: ");
		students.forEach(student -> {
			System.out.println(student.toString());
		});

		Collections.sort(students);
		System.out.println("Sorted by natural sort");
		students.forEach(student -> {
			System.out.println(student.toString());
		});
		
		System.out.println("Sorted by name sort");
		students.sort(new StudentNameComparator());
		students.forEach(student -> {
			System.out.println(student.toString());
		});
		
		System.out.println("Sorted by fees outstanding sort");
		students.sort(new StudentFeesOutstandingComparator());
		students.forEach(student -> {
			System.out.println(student.toString());
		});

	}
}