package com.leonardchow.club.model;

public class Facility {
    public Facility (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Facility (String name) {
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
