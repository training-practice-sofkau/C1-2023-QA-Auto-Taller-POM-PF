package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estudiante {

    public String name;
    public String lastName;
    public String email;
    public Gender gender;
    public String mobilenumber;
    public String dateofBirth;
    public List<String> subject;
    public List<Hobbies> hobbies;
    public String currentAddress;
    public String state;
    public String city;


    public Estudiante(String name, String lastName, String email, Gender gender, String mobilenumber, String dateofBirth, List<String> subject, List<Hobbies> hobbies, String currentAddress, String state, String city) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobilenumber = mobilenumber;
        this.dateofBirth = dateofBirth;
        this.subject = subject;
        this.hobbies = hobbies;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }
    public Estudiante() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
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
