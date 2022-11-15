package com.app.portfolio.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @Builder
    public Portfolio(int portfolioId, String portfolioName, User user, List<Coin> coins) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.user = user;
        this.coins = coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return portfolioId == portfolio.portfolioId && Objects.equals(portfolioName, portfolio.portfolioName) && Objects.equals(user, portfolio.user) && Objects.equals(coins, portfolio.coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolioId, portfolioName, user, coins);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "portfolioId = " + portfolioId + ", " +
                "portfolioName = " + portfolioName + ", " +
                "user = " + user + ")";
    }
}
