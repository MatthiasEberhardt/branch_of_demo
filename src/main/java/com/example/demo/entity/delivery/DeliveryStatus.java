package com.example.demo.entity.delivery;

public enum DeliveryStatus {
    /*
    IN_CREATION: user is still creating delivery, not all attributes set
    CREATED: delivery created, no vehicle dispatched yet
    AT_SENDER: vehicle dispatched
    TO_WAREHOUSE: delivery in vehicle from sender to warehouse
    AT_WAREHOUSE: delivery at warehouse
    TO_RECEIVER: delivery in vehicle from warehouse to receiver
    CANCELLED: delivery cancelled
     */
    IN_CREATION, CREATED, AT_SENDER, TO_WAREHOUSE, AT_WAREHOUSE, TO_RECEIVER, AT_RECEIVER, CANCELLED
}
