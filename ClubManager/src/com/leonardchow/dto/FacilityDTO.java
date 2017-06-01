package com.leonardchow.dto;

import java.io.Serializable;

public class FacilityDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacilityDTO (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FacilityDTO (String name) {
        this(name, "");
    }

    public String show() {
        return this.toString();
    }

    public String toString () {
        return name + (description.isEmpty() ? "" : " (" + description + ")");
    }

    private String name;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private String description;
}
