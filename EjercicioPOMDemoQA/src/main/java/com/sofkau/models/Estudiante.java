package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.List;

public class Estudiante {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String userNumber;
    private List<String> subjects;
    private List<Hobbies> hobbies;

    private String picture;
    private String city;
    private String state;
    private String adressUsuario;
    private String dateofBirth;

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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Hobbies> getHobbies () {
        return hobbies;
    }

    public void setHobbies (List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdressUsuario() {
        return adressUsuario;
    }

    public void setAdressUsuario(String adressUsuario) {
        this.adressUsuario = adressUsuario;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
}
