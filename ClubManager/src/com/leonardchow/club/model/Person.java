package com.leonardchow.club.model;

public class Person {
    private String surname, firstName, secondName;

    public Person (String surname, String firstName, String secondName) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Person (String surname, String firstName) {
        this(surname, firstName, "");
    }

    public String toString() {
        return firstName + (secondName.isEmpty() ? " " : " " + secondName + " ") + surname;
    }

    public String show() {
        return this.toString();
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
}
