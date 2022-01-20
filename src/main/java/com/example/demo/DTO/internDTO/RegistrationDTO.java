package com.example.demo.DTO.internDTO;

import javax.validation.constraints.*;

//@PasswordMatches
public class RegistrationDTO {

    private static final String ERROR_MESSAGE_EMPTY = "%s must not be empty";

    //@NotNull(message = "username can not be empty")
    @NotBlank(message = "username can not be empty")
    private String username;
    //@NotNull(message = "password can not be empty")
    @NotBlank(message = "password can not be empty")
    @Size(min = 8, message = "password must contain at least 8 characters")
    //@Pattern(regexp = "[A-Z]+", message = "password must contain at least one capital letter")
    //@Pattern(regexp = "[a-z]+", message = "password must contain at least one lower case letter")
    //@Pattern(regexp = "[0-9]+", message = "password must contain at least one digit")
    //@Pattern(regexp = "[^[A-Za-z0-9]]+", message = "password must contain at least one special character")
    //@Pattern(regexp = "([A-Z]+)+([a-z]+)+([0-9]+)+", message = "password must contain at least one digit, one capital letter,"+
    //    " one lowercase letter and one special character")
    private String password;
    //@NotNull(message = "password confirmation can not be empty")
    @NotBlank(message = "password confirmation can not be empty")
    private String passwordConfirmed;
    //@NotNull(message = "city can not be empty")
    @NotBlank(message = "city can not be empty")
    private String city;
    //@NotNull(message = "street can not be empty")
    @NotBlank(message = "street can not be empty")
    private String street;
    //@NotNull(message = "postalCode can not be empty")
    @NotBlank(message = "postalCode can not be empty")
    @Pattern(regexp = "[0-9]{5}", message = "postalCode must be 5 integers")
    private String postalCode;
    //@NotNull(message = "house nr can not be empty")
    @Min(value=1,message="house nr must be equal or greater than 1")
    private int houseNr;
    private String role;

    private String firstName;
    private String familyName;
    private String companyName;

    private String adminPassword;

    public RegistrationDTO() {
        this.role = "person";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmed='" + passwordConfirmed + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", houseNr=" + houseNr +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
