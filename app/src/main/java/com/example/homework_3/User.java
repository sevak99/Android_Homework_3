package com.example.homework_3;

import java.io.Serializable;

/**
 * Created by SEVAK on 28.04.2017.
 */

public class User implements Serializable {

    private static int idNumber = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String gender;
    private int age;
    private String bio;

    public User(String firstName, String lastName, String userName, String gender, int age) {
        id = idNumber++;

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserName: ").append(userName).append("\n")
                .append("First Name: ").append(firstName).append("\n")
                .append("Last Name: ").append(lastName).append("\n")
                .append("Gender: ").append(gender).append("\n")
                .append("Age: ").append(age);
        return stringBuilder.toString();
    }
}
