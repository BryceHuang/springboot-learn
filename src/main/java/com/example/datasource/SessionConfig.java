package com.example.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 600)
public class SessionConfig  {
    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDataSource;

    @Bean(name = "sessionTransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(secondaryDataSource);
    }

//    @Bean
//    public void setTransactionManager(PlatformTransactionManager transactionManager) {
//    }

    @Bean(name="sessionDataSource")
    @SpringSessionDataSource
    public DataSource sessionDataSource(){
        return secondaryDataSource;
    }



}
