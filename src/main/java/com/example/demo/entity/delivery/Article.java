package com.example.demo.entity.delivery;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ARTICLE")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ARTICLE_ID")
    private int id;
    @Column(name="HEIGHT")
    private int height;
    @Column(name="WIDTH")
    private int width;
    @Column(name="LENGTH")
    private int length;
    @Column(name="WEIGHT")
    private int weight;
    @Column(name="DESCRIPTION")
    private String description;


    @Column(name="CONTENT")
    private String content;
    @Column(name="AMOUNT")
    private int amount;



    public Article(){

    }

    public Article(int height, int width, int length, int weight) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.amount = 1;
    }

    public Article(int height, int width, int depth, int weight, String description) {
        this.height = height;
        this.width = width;
        this.length = depth;
        this.weight = weight;
        this.description = description;
        this.amount = 1;
    }

    public static Article createLetter(String content){
        Article article=new Article(125,235,10, 20, "A letter");
        article.setContent(content);
        return article;
    }

    @Override
    public String toString(){
        return "Article-id: "+this.id;
    }

    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        else if(o.getClass()!=this.getClass()){
            return false;
        }
        else{
            Article o_art=(Article)o;
            return this.id==o_art.id;
        }
    }


    @Override
    public int hashCode(){
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
