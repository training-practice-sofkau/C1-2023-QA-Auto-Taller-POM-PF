package com.sofkau;

import com.sofkau.models.Estudiante;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public Estudiante juan = new Estudiante();

    public Repository() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        subjects.add("Arts");
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        juan.setName("Juan");
        juan.setLastName("Perez");
        juan.setEmail("j.cardona1@gmail.com");
        juan.setGender(Gender.MALE);
        juan.setMobilenumber("3215854785");
        juan.setDateofBirth("20 Feb 2020");
        juan.setSubject(subjects);
        juan.setHobbies(hobbies);
        juan.setCurrentAddress("Calle 32 no 4-51");
        juan.setState("NCR");
        juan.setCity("Delhi");
    }

    public Estudiante generateStudent() {
        return juan;
    }
}
