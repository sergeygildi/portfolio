package com.app.portfolio.dao;

import com.app.portfolio.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Data
public class UserDao {
    private List<User> list = Collections.emptyList();
}
