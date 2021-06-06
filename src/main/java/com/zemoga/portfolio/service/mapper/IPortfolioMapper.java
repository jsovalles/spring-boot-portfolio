package com.zemoga.portfolio.service.mapper;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.dao.entity.Portfolio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPortfolioMapper {
    DTOPortfolio toDTOPortfolio(Portfolio portfolio);

    Portfolio toPortfolio(Integer id, DTOPortfolio portfolio);
}
