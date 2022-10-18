package com.app.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "quotes")
@Entity
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "price")
    private String price;
}
