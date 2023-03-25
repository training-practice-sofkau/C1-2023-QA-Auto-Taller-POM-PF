package com.sofkau.models;

import com.sofkau.util.Gender;

import java.util.List;


public class Estudiante {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobileNumber;
    private String dateOfBirth;
    private List<String> Subject;
   // private List<Hobbies> hobbies;
    private String picture;
    private String CurrentAddress;
    private String stateAndCity;

    public Estudiante() {
    }

    public String firstName() {
        return firstName;
    }

    public Estudiante(String firstName, String lastName, String email, Gender gender, String mobileNumber, String dateOfBirth, List<String> subject, String picture, String currentAddress, String stateAndCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        Subject = subject;
        this.picture = picture;
        CurrentAddress = currentAddress;
        this.stateAndCity = stateAndCity;
    }

    public Estudiante setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public Estudiante setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String email() {
        return email;
    }

    public Estudiante setEmail(String email) {
        this.email = email;
        return this;
    }

    public Gender gender() {
        return gender;
    }

    public Estudiante setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String mobileNumber() {
        return mobileNumber;
    }

    public Estudiante setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public String dateOfBirth() {
        return dateOfBirth;
    }

    public Estudiante setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public List<String> Subject() {
        return Subject;
    }

    public Estudiante setSubject(List<String> subject) {
        Subject = subject;
        return this;
    }

    public String picture() {
        return picture;
    }

    public Estudiante setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String CurrentAddress() {
        return CurrentAddress;
    }

    public Estudiante setCurrentAddress(String currentAddress) {
        CurrentAddress = currentAddress;
        return this;
    }

    public String stateAndCity() {
        return stateAndCity;
    }

    public Estudiante setStateAndCity(String stateAndCity) {
        this.stateAndCity = stateAndCity;
        return this;
    }
}
