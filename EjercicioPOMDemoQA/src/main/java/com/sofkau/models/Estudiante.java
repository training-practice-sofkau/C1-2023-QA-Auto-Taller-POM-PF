package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbie;
import org.opencv.dnn.Layer;

import java.util.List;

public class Estudiante {

    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String year;
    private String month;
    private String day;
    private List<String> subject;
    private List<String> hobbies;
    private String picture;
    private String currentAddres;
    private String state;
    private String city;

    public Estudiante(String name, String lastName, String email, String gender, String mobile, String year, String month, String day, List<String> subject, List<String> hobbies, String picture, String currentAddres, String state, String city) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.year = year;
        this.month = month;
        this.day = day;
        this.subject = subject;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddres = currentAddres;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
