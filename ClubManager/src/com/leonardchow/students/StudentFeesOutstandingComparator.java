package com.leonardchow.students;

import java.util.Comparator;

public class StudentFeesOutstandingComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return Double.valueOf(o1.getFeeOutstanding() - o2.getFeeOutstanding()).intValue();
	}

}
