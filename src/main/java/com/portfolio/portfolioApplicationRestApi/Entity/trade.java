package com.portfolio.portfolioApplicationRestApi.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trades")
public class trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeID;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "stock_id",nullable = false)
    private stock stock;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String tradeType;

    @Column(nullable = false)
    private LocalDate timestamp;

    public trade() {
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public com.portfolio.portfolioApplicationRestApi.Entity.user getUser() {
        return user;
    }

    public void setUser(com.portfolio.portfolioApplicationRestApi.Entity.user user) {
        this.user = user;
    }

    public com.portfolio.portfolioApplicationRestApi.Entity.stock getStock() {
        return stock;
    }

    public void setStock(com.portfolio.portfolioApplicationRestApi.Entity.stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
