package com.example.demo.entity.misc;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Tuple;
import java.awt.*;

@Embeddable
public class Address {

    @Column(name="HOUSE_NR")
    private int houseNr;
    @Column(name="STREET")
    private String street;
    @Column(name="CITY")
    private String city;
    @Column(name="POSTAL_CODE")
    private String postalCode;

    public Address(){
    }

    public Address(int houseNr, String street, String city, String postalCode) {
        this.houseNr = houseNr;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNr=" + houseNr +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public Point getPosition(){
        Point point = new Point();
        return null;
    }
}
