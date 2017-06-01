package com.leonardchow.students;

public class Student implements Comparable<Student>{
	private String id;
	private String firstName, lastName;
	private Double feeTotal, feePaid;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String firstName, String lastName, Double feeTotal, Double feePaid) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.feeTotal = feeTotal;
		this.feePaid = feePaid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public Double getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(Double feePaid) {
		this.feePaid = feePaid;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", feeTotal=" + feeTotal
				+ ", feePaid=" + feePaid + ", feeOutstanding=" + getFeeOutstanding() + "]";
	}
	@Override
	public int compareTo(Student s) {
		return this.getId().compareTo(s.getId());
	}
	public Double getFeeOutstanding() {
		return feeTotal - feePaid;
	}
	
}
