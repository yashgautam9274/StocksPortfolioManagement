package com.portfolio.portfolioApplicationRestApi.Repository;

import com.portfolio.portfolioApplicationRestApi.Entity.trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<trade,Integer> {
    List<trade> findByUserUserID(int userId);
}
