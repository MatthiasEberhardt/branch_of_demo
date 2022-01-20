package com.example.demo.service.implementation;

import com.example.demo.entity.delivery.Delivery;
import com.example.demo.repository.DeliveryRepository;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImplementation implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Delivery createDelivery(Delivery delivery) {
        //Delivery newDelivery = new Delivery(delivery);
        return deliveryRepository.save(delivery);
    }
}
