package com.app.portfolio.dao;

import com.app.portfolio.model.Portfolio;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Data
@Slf4j
public class PortfolioDao {
    private List<Portfolio> list = Collections.emptyList();

}
