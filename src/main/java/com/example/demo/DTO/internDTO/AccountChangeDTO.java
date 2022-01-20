package com.example.demo.DTO.internDTO;

import com.example.demo.entity.customer.Company;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.customer.Person;

import javax.validation.constraints.NotBlank;

public class AccountChangeDTO extends RegistrationDTO{

    //@NotNull(message = "old password must not be empty")
    @NotBlank(message = "old password must not be empty")
    private String oldPassword;

    public AccountChangeDTO() {
    }

    public AccountChangeDTO(Customer customer) {
        this.setUsername(customer.getUsername());
        this.setCity(customer.getAddress().getCity());
        this.setPostalCode(customer.getAddress().getPostalCode());
        this.setStreet(customer.getAddress().getStreet());
        this.setHouseNr(customer.getAddress().getHouseNr());

    }

    public AccountChangeDTO(Person person) {
        this((Customer) person);
        this.setRole("person");
        this.setFamilyName(person.getSurname());
        this.setFirstName(person.getName());
    }

    public AccountChangeDTO(Company company) {
        this((Customer) company);
        this.setRole("company");
        this.setCompanyName(company.getName());
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
