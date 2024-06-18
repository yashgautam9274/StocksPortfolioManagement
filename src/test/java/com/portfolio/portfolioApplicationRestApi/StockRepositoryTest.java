package com.portfolio.portfolioApplicationRestApi;

import com.portfolio.portfolioApplicationRestApi.Entity.stock;
import com.portfolio.portfolioApplicationRestApi.Repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StockRepositoryTest {
    @Autowired
    StockRepository stockRepository;

    private stock stock = new stock();
    private stock savedStock;
    @BeforeEach
    public void beforeEach(){
        stock.setStockName("Apple");
        stock.setStockID(1);
        stock.setOpenPrice(140);
        stock.setSettlementPrice(124);
        stock.setHighPrice(110);
        stock.setClosePrice(120);
        savedStock = stockRepository.save(stock);
    }

    @Test
    public void testSaveStock(){
        assertThat(savedStock).isNotNull();
        assertThat(savedStock.getStockID()).isGreaterThan(0);
    }

    @Test
    public void testFindByID(){
        Optional<stock> foundStock = stockRepository.findById(savedStock.getStockID());
        assertThat(foundStock).isPresent();
        assertThat(foundStock.get().getStockID()).isEqualTo(savedStock.getStockID());
    }

    @Test
    public void testDeleteStock(){
        stockRepository.deleteById(savedStock.getStockID());
        Optional<stock> foundStock = stockRepository.findById(savedStock.getStockID());
        assertThat(foundStock).isNotPresent();
    }
}
