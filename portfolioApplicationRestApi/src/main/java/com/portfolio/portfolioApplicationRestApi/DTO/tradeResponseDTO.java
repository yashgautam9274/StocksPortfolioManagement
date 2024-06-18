package com.portfolio.portfolioApplicationRestApi.DTO;

import com.portfolio.portfolioApplicationRestApi.Entity.trade;

public class tradeResponseDTO {
    private String status;
    private String message;

    public tradeResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
