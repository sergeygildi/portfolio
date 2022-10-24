package com.app.portfolio.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    @Id
    private int id;
    private String name;
    private User user;

    @MappedCollection(idColumn = "portfolio_id", keyColumn = "portfolio_id")
    private List<Coin> coinList;
}
