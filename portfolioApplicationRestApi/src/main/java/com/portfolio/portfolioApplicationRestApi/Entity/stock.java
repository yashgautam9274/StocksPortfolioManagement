package com.portfolio.portfolioApplicationRestApi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockID;
    @Column
    private String stockName;
    @Column
    private double openPrice;
    @Column
    private double closePrice;
    @Column
    private double highPrice;
    @Column
    private double settlementPrice;

    public stock() {
    }

    public stock(String stockName, double openPrice, double closePrice, double highPrice, double settlementPrice) {
        this.stockName = stockName;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.settlementPrice = settlementPrice;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    @Override
    public String toString() {
        return "stock{" +
                "stockID=" + stockID +
                ", stockName='" + stockName + '\'' +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", settlementPrice=" + settlementPrice +
                '}';
    }
}
