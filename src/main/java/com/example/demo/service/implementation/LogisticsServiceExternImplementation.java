package com.example.demo.service.implementation;

import com.example.demo.entity.delivery.Delivery;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.LogisticsServiceExtern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsServiceExternImplementation implements LogisticsServiceExtern {

    @Autowired
    private DeliveryService deliveryService;


    @Override
    public Delivery createDelivery(Delivery delivery) {
        System.out.println("extern service called");
        return deliveryService.createDelivery(delivery);
    }
}
