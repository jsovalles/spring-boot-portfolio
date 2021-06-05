package com.zemoga.portfolio.dao;

import com.zemoga.portfolio.dao.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPortfolioRepository extends JpaRepository<Portfolio, Integer> {

}
