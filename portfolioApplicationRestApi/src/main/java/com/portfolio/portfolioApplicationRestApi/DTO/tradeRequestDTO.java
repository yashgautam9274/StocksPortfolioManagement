package com.portfolio.portfolioApplicationRestApi.DTO;

public class tradeRequestDTO {

    private int userID;
    private int stockID;
    private String tradeType;
    private int quantity;


    public tradeRequestDTO() {
    }

    public tradeRequestDTO(int userID, int stockID, int quantity, String tradeType) {
        this.userID = userID;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.stockID = stockID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }
}
