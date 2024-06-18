package com.portfolio.portfolioApplicationRestApi.Services;


import com.portfolio.portfolioApplicationRestApi.DTO.portfolioDTO;
import com.portfolio.portfolioApplicationRestApi.Entity.trade;
import com.portfolio.portfolioApplicationRestApi.Entity.user;
import com.portfolio.portfolioApplicationRestApi.Repository.TradeRepository;
import com.portfolio.portfolioApplicationRestApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TradeRepository tradeRepository;


    public List<user> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<user> getUserByID(int userID){
        return userRepository.findById(userID);
    }

    public user saveUser(user user){
        return userRepository.save(user);
    }

    public List<portfolioDTO> getPortfolioByUserId(int userId) {
        List<trade> trades = tradeRepository.findByUserUserID(userId);

        return trades.stream().collect(Collectors.groupingBy(trade::getStock)).entrySet().stream().map(entry -> {
            double totalQuantity = entry.getValue().stream()
                    .mapToDouble(trade -> trade.getTradeType().equalsIgnoreCase("buy") ? trade.getQuantity() : -trade.getQuantity())
                    .sum();

            return new portfolioDTO(
                    entry.getKey().getStockName(),
                    entry.getKey().getStockID(),
                    (int) totalQuantity
            );
        }).collect(Collectors.toList());
    }

    public int getUserPortfolioStockQuantity(int userID, int stockID){
        List<trade> tradesForStock = tradeRepository.findByUserUserID(userID)
                .stream()
                .filter(trade -> trade.getStock().getStockID()== stockID)
                .collect(Collectors.toList());

        return (int) tradesForStock.stream()
                .mapToDouble(trade -> trade.getTradeType().equalsIgnoreCase("buy") ? trade.getQuantity() : -trade.getQuantity())
                .sum();
    }
}
