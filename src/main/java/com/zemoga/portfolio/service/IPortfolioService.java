package com.zemoga.portfolio.service;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;

import java.util.Optional;

public interface IPortfolioService {
    Optional<DTOPortfolio> getUserPortfolio(int id);
}
