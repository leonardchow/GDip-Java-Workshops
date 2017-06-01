package com.leonardchow.dto;

public class PersonDTOImpl implements PersonDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String surname, firstName, secondName;

    public PersonDTOImpl() {
		super();
	}

	public PersonDTOImpl (String surname, String firstName, String secondName) {
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public PersonDTOImpl (String surname, String firstName) {
        this(surname, firstName, "");
    }
    
    @Override
    public String toString() {
        return firstName + (secondName.isEmpty() ? " " : " " + secondName + " ") + surname;
    }
    
    @Override
    public String show() {
        return this.toString();
    }
    
    @Override
    public String getSurname() {
        return surname;
    }
    
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }
    
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Override
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
