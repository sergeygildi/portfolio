package com.app.portfolio.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.app.portfolio")
@PropertySource("classpath:application.properties")
@Slf4j
@Configuration
public class SpringConfig {

//    private final Environment environment;
//
//    @Autowired
//    public SpringConfig(Environment environment) {
//        this.environment = environment;
//    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("dataSource.driverClassName")));
//        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
//        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }


//    @Bean
//    CommandLineRunner initDatabase(QuoterRepo repository) {
//        return args -> {
//            log.info("Preloading " + repository.save(new Quotes(1, "Bilbo Baggins", "100")));
//            log.info("Preloading " + repository.save(new Quotes(2, "Frodo Baggins", "200")));
//        };
//    }
}

