package com.app.portfolio.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

}
