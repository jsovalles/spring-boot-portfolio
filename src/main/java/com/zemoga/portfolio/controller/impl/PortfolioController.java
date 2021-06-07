package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.service.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/portfolio")
public class PortfolioController {

    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/{user-id}")
    public ResponseEntity<DTOPortfolio> getUserPortfolio(@PathVariable(name = "user-id") int id) {
        return new ResponseEntity<>(portfolioService.getUserPortfolio(id), HttpStatus.OK);
    }

    @PutMapping("/{user-id}/modify")
    public ResponseEntity modifyUserPortfolio(@PathVariable(name = "user-id") int id, @RequestBody DTOPortfolio portfolio) {
        portfolioService.modifyUserPortfolio(id, portfolio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}