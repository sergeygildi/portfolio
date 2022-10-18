package com.app.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
@NoArgsConstructor
@ToString
public class Coin {
    @NonNull
    private String symbol;
    @NonNull
    private BigDecimal userBuyPrice;
    @NonNull
    private BigDecimal userCoinVolume;
    private BigDecimal actualPrice;
    private BigDecimal userInvestment;
    private BigDecimal lastInvestmentCost;
    private int profitPercent;
    private BigDecimal profit;

}
