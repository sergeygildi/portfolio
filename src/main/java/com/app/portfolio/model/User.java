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
public class User {
    @Id
    private int id;
    private String name;

    @MappedCollection(idColumn = "user_id", keyColumn = "user_id")
    private List<Portfolio> portfolioList;
}
