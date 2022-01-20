package com.example.demo.entity.customer;

import com.example.demo.DTO.internDTO.RegistrationDTO;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Company extends Customer {

    @Column(name="COMPANY_NAME")
    private String name;


    public Company(){
        this.setRole(Role.COMPANY);
    }

    public Company(RegistrationDTO registrationDTO){
        super(registrationDTO);
        this.setRole(Role.COMPANY);
        this.name = registrationDTO.getCompanyName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
