package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.List;

public class Estudiante {
    private String name;
    private String secondname;
    private String email;
    private String mobile;
    private Gender gender;
    private Hobbies hobbies;

    private String date;
    private String  subject;
    private String picture;
    private String currentAddres;
    private String state;
    private String city;

    public Estudiante() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCurrentAddres() {
        return currentAddres;
    }

    public void setCurrentAddres(String currentAddres) {
        this.currentAddres = currentAddres;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
