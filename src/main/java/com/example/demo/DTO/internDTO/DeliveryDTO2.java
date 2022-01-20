package com.example.demo.DTO.internDTO;

import com.example.demo.entity.customer.Customer;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeliveryDTO2 {
    //@NotNull(message = "City must not be empty")
    @NotBlank(message = "City must not be empty")
    private String city;
    //@NotNull(message = "Street must not be empty")
    @NotBlank(message = "Street must not be empty")
    private String street;
    //@NotNull(message = "Postal code must not be empty")
    @NotBlank(message = "Postal code must not be empty")
    private String postalCode;
    @Min(value = 1, message =  "House nr must be greater than 0")
    private int houseNr;

    private int daysToStore;

    private String helpAttributeForErrorMessage;

    //@Min(value = 1, message = "Article width must be greater than 0")
    private int articleWidth;
    //@Min(value = 1, message = "Article length must be greater than 0")
    private int articleLength;
    //@Min(value = 1, message = "Article height must be greater than 0")
    private int articleHeight;
    //@Min(value = 1, message = "Article height must be greater than 0")
    private int articleWeight;
    //@Min(value = 1, message = "Article length must be greater than 0")
    private String articleDescription;
    //@Min(value = 1, message = "Article number must be greater than 0")
    private String articleContent;
    private int articleNumber;

    @Valid
    private List<ArticleDTO> articles;

    private Customer sender;

    private static AtomicInteger counter;

    public DeliveryDTO2() {
        articles=new ArrayList<>();
        counter = new AtomicInteger(0);
    }

    public void add(){
        ArticleDTO articleDTO = new ArticleDTO(counter.incrementAndGet());
        articleDTO.setDescription(articleDescription);
        articleDTO.setHeight(articleHeight);
        articleDTO.setLength(articleLength);
        articleDTO.setWeight(articleWeight);
        articleDTO.setWidth(articleWidth);
        articleDTO.setNumber(articleNumber);
        articleDTO.setContent(articleContent);
        articleDescription="";
        articleContent="";
        articleWidth=0;
        articleHeight=0;
        articleLength=0;
        articleWeight=0;
        articleNumber=0;
        articles.add(articleDTO);
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getDaysToStore() {
        return daysToStore;
    }

    public void setDaysToStore(int daysToStore) {
        this.daysToStore = daysToStore;
    }

    @Override
    public String toString() {
        return "DeliveryDTO2{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", houseNr=" + houseNr +
                ", articleWidth=" + articleWidth +
                ", articleLength=" + articleLength +
                ", articleHeight=" + articleHeight +
                ", articleWeight=" + articleWeight +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleNumber=" + articleNumber +
                ", articles=" + articles +
                ", sender=" + sender +
                '}';
    }
}
