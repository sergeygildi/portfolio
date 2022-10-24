package com.app.portfolio.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Quotes {
    @Id
    private String symbol;
    private String price;
}
