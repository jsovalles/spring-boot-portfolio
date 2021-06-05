package com.zemoga.portfolio.service.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.dao.IPortfolioRepository;
import com.zemoga.portfolio.service.IPortfolioService;
import com.zemoga.portfolio.service.mapper.IPortfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PortfolioServiceImpl implements IPortfolioService {

    @Autowired
    private IPortfolioRepository iPortfolioRepository;

    @Autowired
    private IPortfolioMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<DTOPortfolio> getUserPortfolio(int id) {
        return Optional.of(mapper.toDTOPortfolio(iPortfolioRepository.getById(id)));
    }
}