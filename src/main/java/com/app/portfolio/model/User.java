package com.app.portfolio.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Data
@Component
public class User {
    private String name;
    private String password;
    private List<Portfolio> userPortfolioList;
    private BigDecimal userProfit;
    private BigDecimal currentUserPortfolioInvestmentNumber;
}