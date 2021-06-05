package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.controller.IPortfolioController;
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
@RequestMapping(value = "/portfolio")
public class PortfolioControllerImpl implements IPortfolioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioControllerImpl.class);

    @Autowired
    private IPortfolioService iPortfolioService;

    @GetMapping("/{user-id}")
    public String getUserPortfolio(@PathVariable(name = "user-id") int id, Model model) {
        model.addAttribute("portfolio", iPortfolioService.getUserPortfolio(id));
        return "index";
    }

}
