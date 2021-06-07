package com.zemoga.portfolio.service.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.dao.IPortfolioRepository;
import com.zemoga.portfolio.dao.entity.Portfolio;
import com.zemoga.portfolio.service.PortfolioLogic;
import com.zemoga.portfolio.service.mapper.IPortfolioMapper;
import com.zemoga.portfolio.utils.DummyMock;
import com.zemoga.portfolio.utils.UtilsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioServiceImplTest {

    @InjectMocks
    private PortfolioServiceImpl service;

    @Mock
    private IPortfolioRepository repository;

    @Mock
    private IPortfolioMapper mapper;

    @Mock
    private PortfolioLogic logic;

    DummyMock mock;

    @Before
    public void init() {
        this.mock = new DummyMock();
    }

    @Test
    public void getUserPortfolio() {
        when(repository.getById(any())).thenReturn(mock.getPortfolio());
        when(mapper.toDTOPortfolio(any(Portfolio.class))).thenReturn(mock.getDTOPortfolio());
        DTOPortfolio portfolio = service.getUserPortfolio(1);
        Assert.assertNotNull(portfolio);
    }

    @Test(expected = EntityNotFoundException.class)
    public void getUserPortfolioNotFoundException() {
        when(repository.getById(any())).thenThrow(EntityNotFoundException.class);
        DTOPortfolio portfolio = service.getUserPortfolio(99);
    }

    @Test
    public void modifyUserPortfolio() {
        when(mapper.toPortfolio(anyInt(), any(DTOPortfolio.class))).thenReturn(mock.getPortfolio());
        service.modifyUserPortfolio(1, mock.getDTOPortfolio());
    }

    @Test(expected = UtilsException.class)
    public void modifyUserPortfolioUtilsException() {
        doThrow(UtilsException.class).when(logic).checkIfUserExists(anyInt());
        service.modifyUserPortfolio(1, mock.getDTOPortfolio());
    }
}