package com.leonardchow.students;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int result = o1.getLastName().compareTo(o2.getLastName());
		if (result == 0) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		} else {
			return result;
		}
	}

}
