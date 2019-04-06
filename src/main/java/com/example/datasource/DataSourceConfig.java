package com.example.datasource;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.jdbcdslog.ConnectionPoolDataSourceProxy;
import org.jdbcdslog.JdbcDsLogRuntimeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;


@Configuration
public class DataSourceConfig {

//    @Value("${spring.datasource.secondary.jndi-name:false}")
//    private String cronJndiName;
//
//    @Bean(name = "dataSource")
//    @Qualifier("dataSource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        System.out.println(" db built");
//        return DataSourceBuilder.create().build();
//    }



    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        System.out.println("primary db built");
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource sessionDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "org.springframework.context.annotation.internalPersistenceAnnotationProcessor")
//    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
//        PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor = new PersistenceAnnotationBeanPostProcessor();
//        persistenceAnnotationBeanPostProcessor.setDefaultPersistenceUnitName("default");
//        return persistenceAnnotationBeanPostProcessor;
//    }

//    @Bean
//    public DataSource cronDataSource() throws JdbcDsLogRuntimeException {
//        final ConnectionPoolDataSourceProxy proxy = new ConnectionPoolDataSourceProxy();
////        final String jndi = getCronJndi().getJndiName();
////        if (StringUtils.isNotBlank(jndi) && !"false".equals(jndi)) {
////            JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
////            DataSource dataSource = jdsl.getDataSource(jndi);
////            proxy.setTargetDSDirect(dataSource);
////        } else {
//            proxy.setTargetDSDirect(sessionDataSource());
////        }
//        return proxy;
//    }
//
//    @Bean(name = "org.springframework.context.annotation.internalPersistenceAnnotationProcessor")
//    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
//        PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor = new PersistenceAnnotationBeanPostProcessor();
//        persistenceAnnotationBeanPostProcessor.setDefaultPersistenceUnitName("default");
//        return persistenceAnnotationBeanPostProcessor;
//    }


//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.cron")
//    public JndiPropertyHolder getCronJndi() {
//        return new JndiPropertyHolder();
//    }
}
