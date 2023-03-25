package com.sofkau.models;

import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.List;

public class Student {
    private String name;

    private String lastName;

    private String email;

    private Gender gender;

    private String mobile;

    private String year;

    private String month;

    private String day;

    private List<String> subjects;

    private List<Hobbies> hobbies;

    private String picture;

    private String currentAddress;

    private String state;

    private String city;

    public Student(String name, String lastName, String email, Gender gender, String mobile, String year, String month, String day, List<String> subjects, List<Hobbies> hobbies, String picture, String currentAddress, String state, String city) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.year = year;
        this.month = month;
        this.day = day;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }



    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() { return city;
    }
}
