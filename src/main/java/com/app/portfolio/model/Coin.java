package com.app.portfolio.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coin_id")
    private int coinId;
    @Column(name = "coin_symbol")
    private String coinSymbol;
    @Column(name = "coin_buy_price")
    private String coinBuyPrice;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @Builder
    public Coin(int coinId, String coinSymbol, String coinBuyPrice, Portfolio portfolio) {
        this.coinId = coinId;
        this.coinSymbol = coinSymbol;
        this.coinBuyPrice = coinBuyPrice;
        this.portfolio = portfolio;
    }
}
