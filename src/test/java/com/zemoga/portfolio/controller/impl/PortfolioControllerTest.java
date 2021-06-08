package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.service.impl.PortfolioServiceImpl;
import com.zemoga.portfolio.utils.DummyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerTest {

    @InjectMocks
    private PortfolioController portfolioController;

    @Mock
    private PortfolioServiceImpl service;

    DummyMock mock;

    @Before
    public void init() {
        this.mock = new DummyMock();
    }

    @Test
    public void getUserPortfolioOkResponse() {
        when(service.getUserPortfolio(anyInt())).thenReturn(mock.getDTOPortfolio());
        ResponseEntity<DTOPortfolio> portfolio = portfolioController.getUserPortfolio(1);
        Assert.assertNotNull(portfolio);
        Assert.assertEquals(portfolio.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void modifyUserPortfolioNoContentResponse() {
        ResponseEntity response = portfolioController.modifyUserPortfolio(1, mock.getDTOPortfolio());
        Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}