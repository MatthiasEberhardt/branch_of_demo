package com.example.demo.entity.customer;

import com.example.demo.DTO.internDTO.RegistrationDTO;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends Customer {

    @Column(name="SURNAME")
    private String surname;
    @Column(name="NAME")
    private String name;

    public Person(){
        this.setRole(Role.PERSON);
    }

    public Person(RegistrationDTO registrationDTO){
        super(registrationDTO);
        this.setRole(Role.PERSON);
        this.surname = registrationDTO.getFamilyName();
        this.name = registrationDTO.getFirstName();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
