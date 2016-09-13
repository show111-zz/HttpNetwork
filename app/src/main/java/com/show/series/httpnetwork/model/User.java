package com.show.series.httpnetwork.model;

/**
 * Created by lihf on 16/9/9.
 */
public class User {

    private final String firstName;
    private final String lastName;
    private  String displayName;
    private int age;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(int age, String firstName, String lastName) {
        this(firstName, lastName);
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    public boolean isAdult() {
        return age >= 18;
    }

}
