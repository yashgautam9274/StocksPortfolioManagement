package com.portfolio.portfolioApplicationRestApi.Services;

import com.portfolio.portfolioApplicationRestApi.DTO.stockDTO;
import com.portfolio.portfolioApplicationRestApi.DTO.tradeRequestDTO;
import com.portfolio.portfolioApplicationRestApi.DTO.tradeResponseDTO;
import com.portfolio.portfolioApplicationRestApi.Entity.stock;
import com.portfolio.portfolioApplicationRestApi.Entity.trade;
import com.portfolio.portfolioApplicationRestApi.Entity.user;
import com.portfolio.portfolioApplicationRestApi.Repository.StockRepository;
import com.portfolio.portfolioApplicationRestApi.Repository.TradeRepository;
import com.portfolio.portfolioApplicationRestApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class tradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UserRepository userRepository;

    public tradeResponseDTO processTrade(tradeRequestDTO tradeRequestDTO){
        Optional<user> userOpt = userRepository.findById(tradeRequestDTO.getUserID());
        if(userOpt.isEmpty()){
            return new tradeResponseDTO("Failure","Invalid User Account ID");
        }

        Optional<stock> stockOpt = stockRepository.findById(tradeRequestDTO.getStockID());
        int userID = tradeRequestDTO.getUserID();
        int stockID = tradeRequestDTO.getStockID();
        System.out.println(stockID);
        System.out.println(userID);
        if(stockOpt.isEmpty()){
            return new tradeResponseDTO("Failure","Invalid Stock ID");
        }

        if(!"Buy".equalsIgnoreCase(tradeRequestDTO.getTradeType()) && !"Sell".equalsIgnoreCase(tradeRequestDTO.getTradeType())){
            return new tradeResponseDTO("Failure","Invalid Trade Type");
        }

        if(tradeRequestDTO.getQuantity()<=0){
            return new tradeResponseDTO("Failure","Quantity must be positive");
        }

        int yo = userRepository.findUserPortfolioStockQuantity(userID,stockID);
        System.out.println(yo);
        if("Sell".equalsIgnoreCase(tradeRequestDTO.getTradeType())){
             if(tradeRequestDTO.getQuantity()>yo){
                 return new tradeResponseDTO("Failure","You don't have that much quantity to sell");
             }
             else{
                return new tradeResponseDTO("Success","Process Completed");
             }
        }
        String result = exeuteTrade(tradeRequestDTO);
        if(result.equals("Success")){
            return new tradeResponseDTO("Success","Process Completed");
        }
        return new tradeResponseDTO("Failure","fail");

    }

    private String exeuteTrade(tradeRequestDTO tradeRequestDTO){
        trade trade = convertToEntity(tradeRequestDTO);
        tradeRepository.save(trade);
        return "Success";
    }

    public List<trade> getTradesByUserID(int id){
        return tradeRepository.findByUserUserID(id);
    }

    private trade convertToEntity(tradeRequestDTO tradeRequestDTO){
        user user = userRepository.findById(tradeRequestDTO.getUserID())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + tradeRequestDTO.getUserID()));
        stock stock = stockRepository.findById(tradeRequestDTO.getStockID())
                .orElseThrow(() -> new IllegalArgumentException("Invalid stock ID: " + tradeRequestDTO.getStockID()));
        trade trade = new trade();
        trade.setUser(user);
        trade.setStock(stock);
        trade.setQuantity(tradeRequestDTO.getQuantity());
        trade.setPrice(100.5);
        trade.setTradeType(tradeRequestDTO.getTradeType());
        trade.setTimestamp(LocalDate.now());
        return tradeRepository.save(trade);
    }
}
