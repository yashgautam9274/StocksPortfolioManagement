package com.portfolio.portfolioApplicationRestApi.Repository;

import com.portfolio.portfolioApplicationRestApi.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<user,Integer> {
  @Query("SELECT SUM(t.quantity) FROM trade t WHERE t.user.userID = :userID AND t.stock.stockID = :stockID")
  int findUserPortfolioStockQuantity(@Param("userID") int userID, @Param("stockID") int stockID);
}
