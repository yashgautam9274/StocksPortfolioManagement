package com.portfolio.portfolioApplicationRestApi.DTO;

public class stockDTO {
    private int stockID;
    private String stockName;
    private double openPrice;
    private double closePrice;
    private double highPrice;
    private double settlementPrice;

    public stockDTO() {
    }

    public stockDTO(int stockID, String stockName, double openPrice, double closePrice, double highPrice, double settlementPrice) {
        this.stockID = stockID;
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
}
