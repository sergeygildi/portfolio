package com.app.portfolio.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int usersId;
    @Column(name = "user_name")
    private String usersName;
    @Column(name = "user_password")
    private String userPassword;

    @OneToMany(mappedBy = "user")
    private List<Portfolio> portfolios;

}
