package com.app.portfolio.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "quotes")
public class Quotes {
    @Id
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "price")
    private String price;

    @Builder
    public Quotes(String symbol, String price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quotes quotes = (Quotes) o;
        return symbol != null && Objects.equals(symbol, quotes.symbol);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
