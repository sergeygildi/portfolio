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
public class Coin {

    @Id
    private int id;
    private String symbol;
    private Portfolio portfolio;

    @MappedCollection(idColumn = "coin_id", keyColumn = "coin_id")
    private List<Coin> coinList;
}
