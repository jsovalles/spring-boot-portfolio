package com.zemoga.portfolio.dao.impl;

import com.zemoga.portfolio.dao.IPortfolioRepository;
import com.zemoga.portfolio.dao.entity.Portfolio;
import com.zemoga.portfolio.utils.DummyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class PortfolioDatabaseTest {

    @Autowired
    private IPortfolioRepository portfolioRepository;

    DummyMock mock;

    @Before
    public void init() {
        this.mock = new DummyMock();
    }

    @Test
    public void getUserPortfolio() {
        Portfolio portfolio = portfolioRepository.getById(1);
        Assert.assertEquals(portfolio.getId(), mock.getPortfolio().getId());
        Assert.assertEquals(portfolio.getDescription(), mock.getPortfolio().getDescription());
        Assert.assertEquals(portfolio.getImageUrl(), mock.getPortfolio().getImageUrl());
        Assert.assertEquals(portfolio.getTitle(), mock.getPortfolio().getTitle());
        Assert.assertEquals(portfolio.getImageUrl(), mock.getPortfolio().getImageUrl());
    }

    @Test
    public void modifyUserPortfolio() {
        Portfolio portfolio = portfolioRepository.save(mock.getPortfolioDatabaseTest());
        Assert.assertEquals(portfolio.getDescription(), mock.getPortfolioDatabaseTest().getDescription());
    }

}