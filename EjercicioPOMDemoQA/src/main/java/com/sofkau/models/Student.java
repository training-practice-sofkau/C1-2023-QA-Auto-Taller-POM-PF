package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobile;
    private String date;
    private String subject;
    private Hobbies hobbies;
    private String currentAdress;
    private String state;
    private String city;

    public Student() {
    }

    public Student(String name, String lastName, String email, Gender gender, String mobile, String date, String subject, Hobbies hobbies, String currentAdress, String state, String city) {
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.date = date;
        this.subject = subject;
        this.hobbies = hobbies;
        this.currentAdress = currentAdress;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public String getCurrentAdress() {
        return currentAdress;
    }

    public void setCurrentAdress(String currentAdress) {
        this.currentAdress = currentAdress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
