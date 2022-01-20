package com.example.demo.entity.vehicle;

import com.example.demo.entity.misc.Address;
import com.example.demo.entity.delivery.Delivery;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @Column(name="VEHICLE_ID")
    private int id;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column=@Column(name="START_CITY")),
            @AttributeOverride(name="street",column=@Column(name="START_STREET")),
            @AttributeOverride(name="houseNr",column=@Column(name="START_HOUSE_NR")),
            @AttributeOverride(name="postalCode",column=@Column(name="START_POSTAL_CODE"))
    })
    private Address start;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column=@Column(name="DEST_CITY")),
            @AttributeOverride(name="street",column=@Column(name="DEST_STREET")),
            @AttributeOverride(name="houseNr",column=@Column(name="DEST_HOUSE_NR")),
            @AttributeOverride(name="postalCode",column=@Column(name="DEST_POSTAL_CODE"))
    })
    private Address destination;


    @OneToOne
    @JoinColumn(name="DELIVERY")
    private Delivery delivery;
    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ARRIVAL_DATE")
    private Date arrivalDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CANCEL_DATE")
    private Date cancelDate;

    public static final float SPEED = 1.41f;
    public static final Address WAREHOUSE = new Address(3,"Main Street","Capital City","00001");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getStart() {
        return start;
    }

    public void setStart(Address start) {
        this.start = start;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
}
