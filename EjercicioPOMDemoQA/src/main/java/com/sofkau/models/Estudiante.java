package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import org.openqa.selenium.By;

import java.util.List;

public class Estudiante {
    private String name;

    private String lastName;

    private String email;

    private Gender gender;

    private String mobile;

    private String date;

    private List<String> subjects;

    private Hobbies hobbies;

    private String picture;

    private String currentAdress;

    private String state;

    private String city;

    public Estudiante() {
    }

    public Estudiante(String name, String lastName, String email, Gender gender, String mobile, String date, List<String> subjects, Hobbies hobbies, String picture, String currentAdress, String state, String city) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.date = date;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAdress = currentAdress;
        this.state = state;
        this.city = city;
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
