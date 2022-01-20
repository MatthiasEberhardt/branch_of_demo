package com.example.demo.entity.delivery;

import com.example.demo.DTO.internDTO.ArticleDTO;
import com.example.demo.DTO.internDTO.DeliveryDTO2;
import com.example.demo.entity.customer.Customer;
import com.example.demo.entity.misc.Address;
import com.example.demo.entity.vehicle.Vehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="DELIVERY")
public class Delivery {

    @Id
    @Column(name="DELIVERY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Column(name="DELIVERY")
    private List<Article> delivery;

    @OneToOne
    @JoinColumn(name="SENDER")
    private Customer sender;

    @Column(name="RECEIVER")
    private Address receiver;

    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name="TYPE")
    private DeliveryType type=DeliveryType.DELIVERY_ORDER;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION_DATE")
    private Date priorityDate;

    @JoinColumn(name="VEHICLE")
    @OneToOne(mappedBy = "delivery")
    private Vehicle vehicle;

    public Delivery(){
        //potentially replace with better Datetime class
        priorityDate = new Date();
        status = DeliveryStatus.IN_CREATION;
        delivery = new ArrayList<>();
    }

    public Delivery(DeliveryDTO2 deliveryDTO2){
        priorityDate = new Date();
        this.sender = deliveryDTO2.getSender();
        Address receiver = new Address();
        receiver.setHouseNr(deliveryDTO2.getHouseNr());
        receiver.setStreet(deliveryDTO2.getStreet());
        receiver.setPostalCode(deliveryDTO2.getPostalCode());
        receiver.setCity(deliveryDTO2.getCity());
        this.receiver = receiver;
        status = DeliveryStatus.IN_CREATION;
        delivery = new ArrayList<>();
        for(ArticleDTO articleDTO: deliveryDTO2.getArticles()){
            /*String articleDescription = articleDTO.getDescription();
            int articleWidth = articleDTO.getWidth();
            int articleHeight = articleDTO.getHeight();
            int articleLength = articleDTO.getLength();
            int articleWeight = articleDTO.getWeight();
            int articleNumber = articleDTO.getNumber();*/
            Article article = new Article();
            article.setAmount(articleDTO.getNumber());
            article.setDescription(articleDTO.getDescription());
            article.setHeight(articleDTO.getHeight());
            article.setLength(articleDTO.getLength());
            article.setWeight(articleDTO.getWeight());
            article.setWidth(articleDTO.getWidth());
            delivery.add(article);
            /*for(int j=0;j<articleNumber;j++){
                delivery.add(new Article(articleHeight,articleWidth,articleLength,articleWeight,articleDescription));
            }*/
        }
    }

    public Delivery(Address receiver, Article letter){
        //this.sender=owner;
        this.receiver=receiver;
        this.delivery = new ArrayList<>();
        this.delivery.add(letter);
    }

    public void addArticle(Article article){
        delivery.add(article);
    }

    public DeliveryType getType() {
        return type;
    }

    public void setType(DeliveryType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Article> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Article> delivery) {
        this.delivery = delivery;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Address getReceiver() {
        return receiver;
    }

    public void setReceiver(Address receiver) {
        this.receiver = receiver;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Date getPriorityDate() {
        return priorityDate;
    }

    public void setPriorityDate(Date priorityDate) {
        this.priorityDate = priorityDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", delivery=" + delivery +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", status=" + status +
                ", priorityDate=" + priorityDate +
                ", vehicle=" + vehicle +
                '}';
    }
}
