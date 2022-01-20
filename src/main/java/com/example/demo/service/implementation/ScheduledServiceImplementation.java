package com.example.demo.service.implementation;

import com.example.demo.service.DeliveryService;
import com.example.demo.service.ScheduledService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImplementation implements ScheduledService {

    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    VehicleService vehicleService;

    @Scheduled(cron = "*/5 * * * * *")
    @Override
    public void update() {
        //System.out.println("update");
    }
}
