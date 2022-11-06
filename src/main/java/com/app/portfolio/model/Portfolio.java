package com.app.portfolio.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private int portfolioId;
    @Column(name = "portfolio_name")
    private String portfolioName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "portfolio")
    private List<Coin> coins;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "portfolioId = " + portfolioId + ", " +
                "portfolioName = " + portfolioName + ", " +
                "user = " + user + ")";
    }
}
