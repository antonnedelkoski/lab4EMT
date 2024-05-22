package com.example.lab4emt.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private BigDecimal price;
    private String condition;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Default constructor
    public Record() {}

    // Parameterized constructor
    public Record(String title, String artist, BigDecimal price, String condition) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.condition = condition;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}