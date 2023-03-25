package com.sofkau.model;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.List;

public class Estudiante {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String  mobile;
    private String fecha;
    private List<String> subject;
    private Hobbies hobbies;
    private String currentAddres;
    private String state;
    private String city;

    public Estudiante() {
    }

    public Estudiante(String name, String lastName, String email, Gender gender, String mobile, String fecha, List<String> subject, Hobbies hobbies, String currentAddres, String state, String city) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.fecha = fecha;
        this.subject = subject;
        this.hobbies = hobbies;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
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

    @Override
    public String toString() {
        return "Estudiante{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", mobile='" + mobile + '\'' +
                ", fecha='" + fecha + '\'' +
                ", subject=" + subject +
                ", hobbies=" + hobbies +
                ", currentAddres='" + currentAddres + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

