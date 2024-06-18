package com.portfolio.portfolioApplicationRestApi.Controller;

import com.portfolio.portfolioApplicationRestApi.DTO.portfolioDTO;
import com.portfolio.portfolioApplicationRestApi.Entity.user;
import com.portfolio.portfolioApplicationRestApi.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/add")
    public user createUser(@RequestBody user user) {
        return userService.saveUser(user);
    }

    @GetMapping()
    public List<user> getAllUsers(){
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable int id) {
        Optional<user> user = userService.getUserByID(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/portfolio")
    public List<portfolioDTO> getUserPortfolio(@PathVariable int id) {
        return userService.getPortfolioByUserId(id);
    }
    @GetMapping("{userID}/portfolio/{stockID}")
    public int getUserPortfolioStockQuantity(@PathVariable int userID, @PathVariable int stockID){
        return userService.getUserPortfolioStockQuantity(userID,stockID);
    }

}
