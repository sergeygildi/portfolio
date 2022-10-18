package com.app.portfolio.services;

import com.app.portfolio.model.Coin;
import com.app.portfolio.model.Quotes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
class CoinService {
//    private QuotesService quotesService;
//    public static final String ANSI_GREEN_BOLD = "\033[1;32m";
//    public static final String GREEN_BACKGROUND = "\033[42m";
//    public static final String ANSI_RED_BOLD = "\033[1;31m";
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String BLACK_BOLD = "\033[1;30m";
//
//    @Autowired
//    public CoinService(QuotesService quotesService) {
//        this.quotesService = quotesService;
//    }
//
//    public Coin updateCoin(Coin coin) {
//        coin.setActualPrice(getActualCoinPriceBySymbol(coin.getSymbol()));
//        coin.setUserInvestment(getUserInvestmentNumber(coin.getUserCoinVolume(), coin.getUserBuyPrice()));
//        coin.setLastInvestmentCost(getLastInvestmentCost(coin.getUserCoinVolume(), coin.getActualPrice()));
//        coin.setProfit(getProfitNumber(coin.getLastInvestmentCost(), coin.getUserInvestment()));
//        coin.setProfitPercent(getProfitPercent(coin.getActualPrice(), coin.getUserBuyPrice()));
//        return coin;
//    }
//
//    public void getAllInfoAboutCoin(Coin coin) {
//        log.info("Монета: {}", GREEN_BACKGROUND + BLACK_BOLD + "[" + coin.getSymbol() + "]" + ANSI_RESET);
//        log.info("Инвестиция: ${}", coin.getUserInvestment());
//        log.info("Цена покупки: ${}", coin.getUserBuyPrice());
//        log.info("Актуальная стоимость: ${}", coin.getActualPrice());
//        log.info("Количество монет: {}", coin.getUserCoinVolume());
//        log.info("Актуальная стоимость актива: ${}", coin.getLastInvestmentCost());
//        log.info("Процент профита: {}", getStringWithCurrentColorForPercent(coin.getProfitPercent()));
//        log.info("Прибыль: {}", getStringWithCurrentColorForMoney(coin.getProfit()));
//        log.info("-------");
//    }
//
//    public String getStringWithCurrentColorForPercent(int percent) {
//        if (percent < 0) {
//            return ANSI_RED_BOLD + percent + '%' + ANSI_RESET;
//        } else if (percent == 0) {
//            return percent + "%";
//        } else return ANSI_GREEN_BOLD + '+' + percent + '%' + ANSI_RESET;
//    }
//
//    public String getStringWithCurrentColorForMoney(BigDecimal decimal) {
//        if (decimal.signum() < 0) {
//            return ANSI_RED_BOLD + '$' + decimal + ANSI_RESET;
//        }
//        return ANSI_GREEN_BOLD + '$' + decimal + ANSI_RESET;
//    }
//
//    public void getAllMinusCoinsAtPortfolio(Coin coin) {
//        if (coin.getProfit().signum() < 0) {
//            getAllInfoAboutCoin(coin);
//        }
//    }
//
//    public void getAllPlusCoinsAtPortfolio(Coin coin) {
//        if (coin.getProfit().floatValue() >= 0.0f) {
//            getAllInfoAboutCoin(coin);
//        }
//    }
//
//    public void getCoinsThatGaveMoreThan10Dollars(Coin coin) {
//        if (coin.getProfit().compareTo(BigDecimal.TEN) > 0) {
//            getAllInfoAboutCoin(coin);
//        }
//    }
//
//    public void getCoinsThatGaveMoreThan50ProfitPercents(Coin coin) {
//        if (coin.getProfitPercent() >= 50) {
//            getAllInfoAboutCoin(coin);
//        }
//    }
//
//    public int getProfitPercent(BigDecimal actualPrice, BigDecimal userBuyPrice) {
//        BigDecimal profitPercent = (
//                (actualPrice.subtract(userBuyPrice))
//                        .divide(userBuyPrice, 2, 2))
//                .multiply(new BigDecimal(100));
//        return profitPercent.intValue();
//    }
//
//    public BigDecimal getProfitNumber(BigDecimal lastInvestmentCost, BigDecimal userInvestment) {
//        return lastInvestmentCost.subtract(userInvestment);
//    }
//
//    public BigDecimal getLastInvestmentCost(BigDecimal userCoinVolume, BigDecimal actualPrice) {
//        return userCoinVolume.multiply(actualPrice);
//    }
//
//    public BigDecimal getUserInvestmentNumber(BigDecimal userCoinVolume, BigDecimal userBuyPrice) {
//        return userBuyPrice.multiply(userCoinVolume);
//    }
//
//    public BigDecimal getActualCoinPriceBySymbol(String symbol) {
//        List<Quotes> list = quotesService.getCurrentQuotesList();
//        if (list.isEmpty()) {
//            log.error("Карта актуальных котировок пуста.");
//            throw new RuntimeException();
//        }
//        String price = list.stream()
//                .filter(x -> x.getSymbol().equals(symbol))
//                .findFirst()
//                .orElseThrow(RuntimeException::new)
//                .getPrice();
//        return new BigDecimal(price);
//    }
}
