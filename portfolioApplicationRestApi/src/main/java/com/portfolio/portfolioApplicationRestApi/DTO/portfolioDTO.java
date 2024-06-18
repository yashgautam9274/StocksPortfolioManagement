package com.portfolio.portfolioApplicationRestApi.DTO;

public class portfolioDTO {
    private String stockName;
    private int stockID;
    private int quantity;

    public portfolioDTO() {
    }

    public portfolioDTO(String stockName, int stockID, int quantity) {
        this.stockName = stockName;
        this.stockID = stockID;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
