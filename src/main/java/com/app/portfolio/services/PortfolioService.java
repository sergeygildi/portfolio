package com.app.portfolio.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class PortfolioService {

}


//    private QuotesService quotesService;
//    private CoinService coinService;
//    private PortfolioDao portfolioDao;
//
//    @Autowired
//    public PortfolioService(QuotesService quotesService, CoinService coinService, PortfolioDao portfolioDao) {
//        this.quotesService = quotesService;
//        this.portfolioDao = portfolioDao;
//        this.coinService = coinService;
//    }

//    public static final String ANSI_GREEN_BOLD = "\033[1;32m";
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String BLACK_BOLD = "\033[1;30m";
//    public static final String PURPLE_BACKGROUND = "\033[45m";
//    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
//    public static final String ANSI_RED_BOLD = "\033[1;31m";

//    public void addNewPortfolio(Portfolio portfolio) {
//        List<Portfolio> list = portfolioDao.getList();
//        if (list.isEmpty()) {
//            portfolioDao.setList(new ArrayList<>());
//        }
//
//        for (Portfolio pf : list) {
//            String name = portfolio.getName();
//            if (pf.getName().equalsIgnoreCase(name)) {
//                portfolioDao.getList().add(portfolio);
//                return;
//            } else {
//                log.warn("Портфолио с таким названием уже создано.");
//            }
//        }
//    }
//
//    public List<Portfolio> getAllPortfolio() {
//        List<Portfolio> list = portfolioDao.getList();
//        if (list.isEmpty()) {
//            log.info("List is empty");
//            return Collections.emptyList();
//        }
//        return list;
//    }
//
//    public Portfolio getPortfolioByName(String name) {
//        List<Portfolio> list = portfolioDao.getList();
//        if (list.isEmpty()) {
//            log.error("List of portfolios is empty.");
//            throw new RuntimeException();
//        }
//
//        for (Portfolio portfolio : list) {
//            if (portfolio.getName().equals(name)) {
//                return portfolio;
//            } else {
//                log.warn("Not found");
//                throw new RuntimeException();
//            }
//        }
//        return null;
//    }

//    public void fillPortfolioWithCoinsFromUserJson(String jsonFileName) {
//        List<Portfolio> list = portfolioDao.getList();
//        if (list.isEmpty()) {
//            portfolioDao.setList(new ArrayList<>());
//        }
//
//        if (!jsonFileName.endsWith(".json")) {
//            jsonFileName += ".json";
//        }
//
//        Portfolio portfolio = parseJsonFromUser(jsonFileName);
//        List<Coin> coins = calculateOtherCoinInfo(portfolio.getCoins());
//        portfolio.setCoins(coins);
////        addNewPortfolio(portfolio);
//        getGlobalInfo(portfolio.getName(), portfolio);
//    }
//
//    @SneakyThrows
//    private Portfolio parseJsonFromUser(String jsonFileName) {
//        return new ObjectMapper().readValue(new File(jsonFileName),
//                new TypeReference<Portfolio>() {
//                });
//    }

//    public void setGlobalInfo(Portfolio portfolio) {
//        portfolio.setUserInvestmentNumber(getUserInvestmentNumber(portfolio.getCoins()));
//        portfolio.setCurrentUserPortfolioInvestmentNumber(
//                getCurrentUserPortfolioInvestmentNumber(portfolio.getCoins())
//        );
//        portfolio.setProfileProfitNumber(getProfileProfit(portfolio.getCoins()));
//        portfolio.setProfitPercent(getProfitPercent(
//                portfolio.getUserInvestmentNumber(),
//                portfolio.getCurrentUserPortfolioInvestmentNumber())
//        );
//    }
//
//    private int getProfitPercent(BigDecimal userInvestmentNumber, BigDecimal currentUserPortfolioInvestmentNumber) {
//        BigDecimal profitPercent = ((currentUserPortfolioInvestmentNumber.subtract(userInvestmentNumber))
//                .divide(userInvestmentNumber, 2, 2))
//                .multiply(new BigDecimal(100));
//        return profitPercent.intValue();
//    }
//
//    public List<Coin> calculateOtherCoinInfo(List<Coin> coins) {
//        coins.replaceAll(coin -> coinService.updateCoin(coin));
//        return coins;
//    }
//
//    @SneakyThrows
//    public void getGlobalInfo(String name, Portfolio portfolio) {
//        setGlobalInfo(portfolio);
//
//        log.info(getEditedPortfolioName(name));
//        log.info("Начальная цена портфеля: " + BLUE_BOLD_BRIGHT + "${}", portfolio.getUserInvestmentNumber() + ANSI_RESET);
//        log.info("Актуальная стоимость портфеля: " + BLUE_BOLD_BRIGHT + "${}", portfolio.getCurrentUserPortfolioInvestmentNumber() + ANSI_RESET);
//        log.info("Процент прибыли портфеля: {}", checkProfitAndTakeTrueColor(portfolio.getProfitPercent()));
//        log.info("Прибыль: {}", checkProfitAndTakeTrueColor(portfolio.getProfileProfitNumber()));
//    }
//
//    private String checkProfitAndTakeTrueColor(BigDecimal profileProfitNumber) {
//        if (profileProfitNumber.signum() < 0) {
//            return ANSI_RED_BOLD + '$' + profileProfitNumber + ANSI_RESET;
//        }
//        return ANSI_GREEN_BOLD + '$' + profileProfitNumber + ANSI_RESET;
//    }
//
//    private String checkProfitAndTakeTrueColor(int profileProfitNumber) {
//        if (profileProfitNumber < 0) {
//            return ANSI_RED_BOLD + profileProfitNumber + '%' + ANSI_RESET;
//        }
//        return ANSI_GREEN_BOLD + '+' + profileProfitNumber + '%' + ANSI_RESET;
//    }
//
//    public void getAllCoinInfoAtPortfolio(String name, Portfolio portfolio) {
//        log.info(getEditedPortfolioName(name));
//        for (Coin coin : portfolio.getCoins()) {
//            coinService.getAllInfoAboutCoin(coin);
//        }
//    }
//
//    public String getEditedPortfolioName(String name) {
//        return PURPLE_BACKGROUND + BLACK_BOLD + "[" + name + "]" + ANSI_RESET;
//    }
//
//    public void getAllMinusCoinsAtPortfolio(String name, Portfolio portfolio) {
//        getEditedPortfolioName(name);
//        for (Coin coin : portfolio.getCoins()) {
//            coinService.getAllMinusCoinsAtPortfolio(coin);
//        }
//    }
//
//    public void getAllPlusCoinsAtPortfolio(String name, Portfolio portfolio) {
//        log.info(getEditedPortfolioName(name));
//        for (Coin coin : portfolio.getCoins()) {
//            coinService.getAllPlusCoinsAtPortfolio(coin);
//        }
//    }
//
//    public void getCoinsThatGaveMoreThan10Dollars(String name, Portfolio portfolio) {
//        getEditedPortfolioName(name);
//        for (Coin coin : portfolio.getCoins()) {
//            coinService.getCoinsThatGaveMoreThan10Dollars(coin);
//        }
//    }
//
//    public void getCoinsThatGaveMoreThan500ProfitPercents(String name, Portfolio portfolio) {
//        getEditedPortfolioName(name);
//        for (Coin coin : portfolio.getCoins()) {
//            coinService.getCoinsThatGaveMoreThan50ProfitPercents(coin);
//        }
//    }
//
//    public BigDecimal getProfileProfit(List<Coin> coinList) {
//        BigDecimal profitSum = BigDecimal.ZERO;
//        checkCoinList(coinList);
//        for (Coin value : coinList) {
//            BigDecimal profit = value.getProfit();
//            profitSum = profit.add(profitSum)
//                    .plus(new MathContext(4, RoundingMode.HALF_UP));
//        }
//        return profitSum;
//    }
//
//    public BigDecimal getUserInvestmentNumber(List<Coin> coinList) {
//        checkCoinList(coinList);
//        BigDecimal userInvestmentSum = BigDecimal.ZERO;
//        for (Coin value : coinList) {
//            BigDecimal userInvestment = value.getUserInvestment();
//            userInvestmentSum = userInvestment.add(userInvestmentSum)
//                    .plus(new MathContext(4, RoundingMode.HALF_UP));
//        }
//        return userInvestmentSum;
//    }
//
//    private void checkCoinList(List<Coin> coinList) {
//        if (coinList.isEmpty()) {
//            log.error("Failed to get (as a passed parameter) the list of available coins from the user.");
//            throw new RuntimeException();
//        }
//    }
//
//    public BigDecimal getCurrentUserPortfolioInvestmentNumber(List<Coin> coinList) {
//        checkCoinList(coinList);
//        BigDecimal sumOfLastInvestmentCost = BigDecimal.ZERO;
//        for (Coin coin : coinList) {
//            BigDecimal lastInvestmentCost = coin.getLastInvestmentCost();
//            sumOfLastInvestmentCost = lastInvestmentCost
//                    .add(sumOfLastInvestmentCost)
//                    .plus(new MathContext(4, RoundingMode.HALF_UP));
//        }
//        return sumOfLastInvestmentCost;
//    }
//
//    public void showCoinsThatGaveTheSpecifiedNumberOfProfit(int expectedProfitPercentage, Portfolio portfolio) {
//        ArrayList<String> symbols = new ArrayList<>();
//        int num = 0;
//
//        for (Coin coin : portfolio.getCoins()) {
//            if (coin.getProfitPercent() >= expectedProfitPercentage) {
//                num++;
//                symbols.add(coin.getSymbol() + ": >$" + coin.getProfit().intValue());
//            }
//        }
//
//        int size = portfolio.getCoins().size();
//
//        String message = getExpectedProfitPercentage(expectedProfitPercentage) + BLUE_BOLD_BRIGHT + num + "/" + size
//                + " [" + showSymbols(symbols) + "] " + ANSI_RESET;
//        if (num != 0) {
//            log.info(message);
//        }
//    }
//
//    private String getExpectedProfitPercentage(int expectedProfitPercentage) {
//        if (expectedProfitPercentage < 100) {
//            return ">" + expectedProfitPercentage + "%: ";
//        }
//        return "x" + ((expectedProfitPercentage / 100) + 1) + ": ";
//    }
//
//    private StringBuilder showSymbols(List<String> symbols) {
//        StringBuilder temp = new StringBuilder();
//        for (String symbol : symbols) {
//            if (temp.length() <= 0) {
//                temp.append(symbol);
//            } else {
//                temp.append(", ").append(symbol);
//            }
//        }
//        return temp;
//    }
//
//    public void showBtcCost(String symbol, String symbol2, String symbol3) {
//        List<Quotes> list = quotesService.getCurrentQuotesList();
//
//        log.info("------------------------");
//        log.info("{} {} {}",
//                setText(symbol, list),
//                setText(symbol2, list),
//                setText(symbol3, list)
//        );
//    }
//
//    private String setText(String symbol, List<Quotes> currentQuotesList) {
//        return setUpperCaseAndSubstringForSymbol(symbol) + ": " + BLUE_BOLD_BRIGHT + "$"
//                + setScaleForSymbols(symbol, currentQuotesList) + ANSI_RESET;
//    }
//
//    private String setUpperCaseAndSubstringForSymbol(String symbol) {
//        return symbol.toUpperCase().substring(0, 3);
//    }
//
//    private BigDecimal setScaleForSymbols(String symbol, List<Quotes> currentQuotesList) {
//        BigDecimal price = BigDecimal.ZERO;
//        for (Quotes quotes : currentQuotesList) {
//            if (quotes.getSymbol().equals(symbol)) {
//                price = new BigDecimal(quotes.getPrice());
//                price.setScale(2, 2);
//            }
//        }
//        return price;
//    }

//}
