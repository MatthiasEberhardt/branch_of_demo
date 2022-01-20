package com.example.demo.DTO.internDTO;

import com.example.demo.entity.customer.Customer;

public class DeliveryDTO {
    private String city;
    private String street;
    private String postalCode;
    private int houseNr;

    private int articleWidth;
    private int articleLength;
    private int articleHeight;
    private int articleWeight;
    private String articleDescription;
    private int articleNumber;

    private String articleWidthList;
    private String articleLengthList;
    private String articleHeightList;
    private String articleWeightList;
    private String articleDescriptionList;
    private String articleNumberList;

    private Customer sender;

    public void add(){
        articleDescriptionList += "|" + articleDescription;
        articleHeightList += "|" + articleHeight;
        articleWeightList += "|" + articleWeight;
        articleLengthList += "|" + articleLength;
        articleWidthList += "|" + articleWidth;
        articleNumberList += "|" + articleNumber;
        articleWidth = 0;
        articleLength = 0;
        articleHeight = 0;
        articleWeight = 0;
        articleDescription = "";
        articleNumber = 0;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public int getArticleWidth() {
        return articleWidth;
    }

    public void setArticleWidth(int articleWidth) {
        this.articleWidth = articleWidth;
    }

    public int getArticleLength() {
        return articleLength;
    }

    public void setArticleLength(int articleLength) {
        this.articleLength = articleLength;
    }

    public int getArticleHeight() {
        return articleHeight;
    }

    public void setArticleHeight(int articleHeight) {
        this.articleHeight = articleHeight;
    }

    public int getArticleWeight() {
        return articleWeight;
    }

    public void setArticleWeight(int articleWeight) {
        this.articleWeight = articleWeight;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getArticleWidthList() {
        return articleWidthList;
    }

    public void setArticleWidthList(String articleWidthList) {
        this.articleWidthList = articleWidthList;
    }

    public String getArticleLengthList() {
        return articleLengthList;
    }

    public void setArticleLengthList(String articleLengthList) {
        this.articleLengthList = articleLengthList;
    }

    public String getArticleHeightList() {
        return articleHeightList;
    }

    public void setArticleHeightList(String articleHeightList) {
        this.articleHeightList = articleHeightList;
    }

    public String getArticleWeightList() {
        return articleWeightList;
    }

    public void setArticleWeightList(String articleWeightList) {
        this.articleWeightList = articleWeightList;
    }

    public String getArticleDescriptionList() {
        return articleDescriptionList;
    }

    public void setArticleDescriptionList(String articleDescriptionList) {
        this.articleDescriptionList = articleDescriptionList;
    }

    public String getArticleNumberList() {
        return articleNumberList;
    }

    public void setArticleNumberList(String articleNumberList) {
        this.articleNumberList = articleNumberList;
    }
}
