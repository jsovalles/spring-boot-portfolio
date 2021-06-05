package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.controller.IPortfolioController;
import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.service.IPortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/portfolio", produces = "application/json")
public class PortfolioControllerImpl implements IPortfolioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioControllerImpl.class);

    @Autowired
    private IPortfolioService iPortfolioService;

    @GetMapping("/{user-id}")
    public ResponseEntity<DTOPortfolio> getUserPortfolio(@PathVariable(name = "user-id") int id){
        return iPortfolioService.getUserPortfolio(id)
                .map(dtoPortfolio -> new ResponseEntity<>(dtoPortfolio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
