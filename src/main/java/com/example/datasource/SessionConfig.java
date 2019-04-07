package com.example.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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

//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Bean(name = "secondaryEntityManager")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactory(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "secondaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(secondaryDataSource)
//                .properties(getVendorProperties())
//                .packages(SpringSessionBean.class)
//                .persistenceUnit("secondaryPersistenceUnit").build();
//    }
//
//
//    private Map<String, String> getVendorProperties() {
//        return jpaProperties.getProperties();
//    }
//
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(secondaryDataSource);
//    }


//    @Bean(name="dataSource")
    @SpringSessionDataSource
    public DataSource sessionDataSource(){
        return secondaryDataSource;
    }



}
