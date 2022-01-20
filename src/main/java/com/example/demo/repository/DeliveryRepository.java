package com.example.demo.repository;

import com.example.demo.entity.delivery.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Integer> {
}
