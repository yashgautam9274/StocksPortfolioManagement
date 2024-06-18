package com.portfolio.portfolioApplicationRestApi.Repository;

import com.portfolio.portfolioApplicationRestApi.Entity.stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<stock,Integer> {
}
