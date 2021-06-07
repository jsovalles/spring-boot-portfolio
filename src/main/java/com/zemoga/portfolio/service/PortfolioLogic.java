package com.zemoga.portfolio.service;

import com.zemoga.portfolio.dao.IPortfolioRepository;
import com.zemoga.portfolio.utils.UtilsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioLogic {

    @Autowired
    IPortfolioRepository portfolioRepository;

    public void checkIfUserExists(int id) {
        if (!portfolioRepository.existsById(id))
            throw new UtilsException();

    }
}
