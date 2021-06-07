package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.service.IPortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioMvc {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioMvc.class);

    @Autowired
    private IPortfolioService portfolioService;

    @Autowired
    private TwitterController twitterController;

    @GetMapping("/{user-id}")
    public String getUserPortfolio(@PathVariable(name = "user-id") int id, Model model) {
        DTOPortfolio portfolio = portfolioService.getUserPortfolio(id);
        model.addAttribute("portfolio", portfolio);
        model.addAttribute("tweets", twitterController.getUserLastFiveTweets(portfolio.getTwitterUserName()));
        return "index";
    }
}
