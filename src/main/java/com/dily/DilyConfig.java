package com.dily;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

/**
 * Created by Andra on 5/7/2017.
 */
public class DilyConfig {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    OracleDataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}
