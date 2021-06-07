package com.zemoga.portfolio.service.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.dao.IPortfolioRepository;
import com.zemoga.portfolio.service.IPortfolioService;
import com.zemoga.portfolio.service.PortfolioLogic;
import com.zemoga.portfolio.service.mapper.IPortfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortfolioServiceImpl implements IPortfolioService {

    @Autowired
    private IPortfolioRepository portfolioRepository;

    @Autowired
    private IPortfolioMapper mapper;

    @Autowired
    PortfolioLogic logic;

    @Override
    @Transactional(readOnly = true)
    public DTOPortfolio getUserPortfolio(int id) {
        return mapper.toDTOPortfolio(portfolioRepository.getById(id));
    }

    @Override
    @Transactional
    public void modifyUserPortfolio(int id, DTOPortfolio portfolio) {
        logic.checkIfUserExists(id);
        portfolioRepository.save(mapper.toPortfolio(id, portfolio));
    }
}
