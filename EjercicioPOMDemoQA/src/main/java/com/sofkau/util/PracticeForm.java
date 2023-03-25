package com.sofkau.util;

import com.sofkau.models.Student;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm {
    public Student student = new Student();
    public List<String> studentList = new ArrayList<>();

    public void fillStudentInfo(){
        student.setFirstName("Checho");
        student.setLastName("Balcazar");
        student.setEmail("sabar@mail.com");
        student.setGender(Gender.Male);
        student.setMobile("6045552558");
        student.setDate("08 september 1991");
        student.setSubject("English");
        student.setHobbies(Hobbies.Sports);
        student.setCurrentAdress("Calle30A55-200");
        student.setState("Haryana");
        student.setCity("Karnal");
    }

    public Student getStudent(){
        return this.student;
    }

}
