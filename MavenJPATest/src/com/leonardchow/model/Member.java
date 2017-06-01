package com.leonardchow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
	
	@Id
	@GeneratedValue
	private int id;
	private String surname;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
	
	public Member() {
		super();
	}
	public Member(int id, String surname, String firstName, String secondName) {
		super();
		this.id = id;
		this.surname = surname;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public Member(String surname, String firstName, String secondName) {
		this(0, surname, firstName, secondName);
	}
	public Member(String surname, String firstName) {
		this(0, surname, firstName, "");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public String toString() {
		return "Member [id=" + id + ", surname=" + surname + ", firstName=" + firstName + ", secondName=" + secondName
				+ "]";
	}
	
}
