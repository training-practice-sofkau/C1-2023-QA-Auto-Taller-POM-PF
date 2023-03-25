package com.sofkau.util;

import com.sofkau.models.Empleado;

public class metodModel {
    public Empleado createEmpleado(){
        Empleado jose = new Empleado();
        jose.setFirstName("Jose");
        jose.setLastName("Nunez");
        jose.setEmail("nunezj@gmail.com");
        jose.setAge("22");
        jose.setSalary("10000");
        jose.setDepartment("QA");
        return jose;
    }
}
