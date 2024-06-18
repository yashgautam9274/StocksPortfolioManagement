package com.portfolio.portfolioApplicationRestApi.Services;

import com.portfolio.portfolioApplicationRestApi.DTO.stockDTO;
import com.portfolio.portfolioApplicationRestApi.Entity.stock;
import com.portfolio.portfolioApplicationRestApi.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class stockService {

    @Autowired
    private StockRepository stockRepository;

    public List<stockDTO> getAllStocks(){
        return stockRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<stockDTO> getStock(int stockID){
        return stockRepository.findById(stockID)
                .map(this::convertToDTO);
    }

    public stockDTO saveStock(stockDTO stockDTO){
        stock stock = convertToEntity(stockDTO);
        stock savedStock = stockRepository.save(stock);
        return convertToDTO(savedStock);
    }

    public void deleteStock(int stockID){
        stockRepository.deleteById(stockID);
    }

    public Optional<stockDTO> updateStock(int stockID, stockDTO stockDTO){
        //System.out.println("First stock in the list: " + stockDTO.get(0));
        Optional<stock> existingStock = stockRepository.findById(stockID);
        if(existingStock.isPresent()){
            stock stock = existingStock.get();
            if(stockDTO.getOpenPrice() != 0.0){
                stock.setOpenPrice(stockDTO.getOpenPrice());
            }
            if(stockDTO.getClosePrice()!=0.0){
                stock.setClosePrice(stockDTO.getClosePrice());
            }
            if(stockDTO.getHighPrice()!=0.0){
                stock.setHighPrice(stockDTO.getHighPrice());
            }
            if(stockDTO.getOpenPrice()!=0.0){
                stock.setOpenPrice(stockDTO.getOpenPrice());
            }
            if(stockDTO.getSettlementPrice()!=0.0){
                stock.setSettlementPrice(stockDTO.getSettlementPrice());
            }
            stock updateStock = stockRepository.save(stock);
            return Optional.of(convertToDTO(updateStock));
        }
        return Optional.empty();
    }

    private stockDTO convertToDTO(stock stock){
        return new stockDTO(
                stock.getStockID(),
                stock.getStockName(),
                stock.getOpenPrice(),
                stock.getClosePrice(),
                stock.getHighPrice(),
                stock.getSettlementPrice()
        );
    }

    private stock convertToEntity(stockDTO stockDTO){
        stock stock = new stock();
        stock.setStockID(stockDTO.getStockID());
        stock.setStockName(stockDTO.getStockName());
        stock.setOpenPrice(stockDTO.getOpenPrice());
        stock.setHighPrice(stockDTO.getHighPrice());
        stock.setClosePrice(stockDTO.getClosePrice());
        stock.setSettlementPrice(stockDTO.getSettlementPrice());
        return stock;
    }
}
