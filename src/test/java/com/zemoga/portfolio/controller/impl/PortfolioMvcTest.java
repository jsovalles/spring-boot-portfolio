package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.PortfolioApplication;
import com.zemoga.portfolio.utils.DummyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = PortfolioApplication.class)
public class PortfolioMvcTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    DummyMock mock;

    private MockMvc mvc;

    @Before
    public void init() {
        this.mock = new DummyMock();
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getUserPortfolio() throws Exception {
        this.mvc.perform(get("/{user-id}", 1)).andDo(print()).andExpect(status().isOk());
    }
}