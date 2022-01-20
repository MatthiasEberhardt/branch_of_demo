package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public interface ScheduledService {

    @Scheduled(cron = "*/5 * * * * *")
    public void update();

}
