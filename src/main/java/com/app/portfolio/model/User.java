package com.app.portfolio.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @Builder
    public User(int usersId, String usersName, String userPassword, List<Portfolio> portfolios) {
        this.usersId = usersId;
        this.usersName = usersName;
        this.userPassword = userPassword;
        this.portfolios = portfolios;
    }

    @Override
    public String toString() {
        return "User{" +
                ", usersName='" + usersName + '\'' +
                ", portfolios=" + portfolios +
                '}';
    }

}
