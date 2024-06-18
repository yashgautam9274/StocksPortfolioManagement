package com.portfolio.portfolioApplicationRestApi.Controller;

import com.portfolio.portfolioApplicationRestApi.DTO.tradeRequestDTO;
import com.portfolio.portfolioApplicationRestApi.DTO.tradeResponseDTO;
import com.portfolio.portfolioApplicationRestApi.Entity.trade;
import com.portfolio.portfolioApplicationRestApi.Services.tradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class tradeController {

    @Autowired
    private tradeService tradeService;

    @PostMapping
    public tradeResponseDTO executeTrade(@RequestBody tradeRequestDTO tradeRequestDTO){
        return tradeService.processTrade(tradeRequestDTO);
    }

    @GetMapping("/user/{userId}")
    public List<trade> getTradesByUserID(@PathVariable int userId) {
        return tradeService.getTradesByUserID(userId);
    }
}
