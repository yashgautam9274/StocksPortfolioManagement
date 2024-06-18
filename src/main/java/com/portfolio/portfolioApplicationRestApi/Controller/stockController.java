package com.portfolio.portfolioApplicationRestApi.Controller;

import com.portfolio.portfolioApplicationRestApi.DTO.stockDTO;
import com.portfolio.portfolioApplicationRestApi.Services.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class stockController {

    @Autowired
    private stockService stockService;

    @GetMapping()
    public List<stockDTO> getAllStocks(){
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Optional<stockDTO> getStock(@PathVariable int id){
        return stockService.getStock(id);
    }

    @PostMapping("/add")
    public stockDTO createStock(@RequestBody stockDTO stockDTO){
        return stockService.saveStock(stockDTO);
    }

    @PutMapping("/update/{id}")
    public Optional<stockDTO> updateStock(@PathVariable int id, @RequestBody stockDTO stockDTO){
        return stockService.updateStock(id,stockDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable int id){
        stockService.deleteStock(id);
    }


}
