package com.example.demo.entity.delivery;

import com.example.demo.DTO.internDTO.DeliveryDTO2;

import javax.persistence.Entity;

@Entity
public class StoreOrder extends Delivery {
    private int daysToStore;

    public StoreOrder() {

    }

    public StoreOrder(DeliveryDTO2 deliveryDTO2) {
        super(deliveryDTO2);
        daysToStore = deliveryDTO2.getDaysToStore();
        setType(DeliveryType.STORE_ORDER);
    }

    public int getDaysToStore() {
        return daysToStore;
    }

    public void setDaysToStore(int daysToStore) {
        this.daysToStore = daysToStore;
    }
}
