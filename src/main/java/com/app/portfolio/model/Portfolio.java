package com.app.portfolio.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Portfolio {
    private String name;
    private List<Coin> coins;

    private BigDecimal userInvestmentNumber;
    private BigDecimal profileProfitNumber;
    private BigDecimal currentUserPortfolioInvestmentNumber;
    private Integer profitPercent;

    public Portfolio(String name) {
        this.name = name;
    }

    public Portfolio(String name, List<Coin> coins) {
        this.name = name;
        this.coins = coins;
    }
}
