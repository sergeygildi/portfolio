create table quotes
(
    symbol varchar(15)  not null primary key,
    price  varchar(100) not null
);

CREATE TABLE users
(
    user_id       INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_name     varchar(100) UNIQUE NOT NULL,
    user_password varchar(100) UNIQUE NOT NULL
);

create table portfolio
(
    portfolio_id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    portfolio_name varchar(100) not null,
    user_id        int          not null ReFERENCES users (user_id) ON DELETE CASCADE
);

alter table users
    add column portfolio_id
        int not null REFERENCES portfolio (portfolio_id) ON DELETE CASCADE;

alter table portfolio
    add column coins_id
        int not null REFERENCES coins (coin_id) ON DELETE CASCADE;

CREATE TABLE coins
(
    coin_id        INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    coin_symbol    varchar(15) UNIQUE not null,
    coin_buy_price varchar(100)       not null,
    portfolio_id   INT                NOT NULL ReFERENCES portfolio (portfolio_id) ON DELETE CASCADE
);
