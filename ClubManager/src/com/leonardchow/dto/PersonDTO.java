package com.leonardchow.dto;

import java.io.Serializable;

public interface PersonDTO extends Serializable {
    public String toString();

    public String show();

    public String getSurname();

    public void setSurname(String surname);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getSecondName();

    public void setSecondName(String secondName);
}
