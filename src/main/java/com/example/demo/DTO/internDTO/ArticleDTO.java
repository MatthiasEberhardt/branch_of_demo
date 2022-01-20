package com.example.demo.DTO.internDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ArticleDTO {

    //@NotNull(message = "Article height must not be empty")
    @Min(value = 1, message = "Article height must be greater than 0")
    private int height;
    @Min(value = 1, message = "Article width must be greater than 0")
    private int width;
    @Min(value = 1, message = "Article length must be greater than 0")
    private int length;
    @Min(value = 1, message = "Article weight must be greater than 0")
    private int weight;
    private String description;
    private String content;
    @Min(value = 1, message = "Article number must be greater than 0")
    private int number;

    private int id;

    public ArticleDTO() {

    }

    public ArticleDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", number=" + number +
                ", id=" + id +
                '}';
    }
}
