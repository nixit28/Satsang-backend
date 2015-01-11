package com.satsang.webapps;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class PersistenceContext {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSourceConfig.setJdbcUrl("jdbc:mysql://${OPENSHIFT_MYSQL_DB_HOST}:${OPENSHIFT_MYSQL_DB_PORT}/${OPENSHIFT_APP_NAME}");
        dataSourceConfig.setUrl("jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/" + System.getenv("OPENSHIFT_APP_NAME"));
        dataSourceConfig.setUsername(System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"));
        dataSourceConfig.setPassword(System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
        dataSourceConfig.setTestOnBorrow(true);
        dataSourceConfig.setTestOnReturn(true);
        dataSourceConfig.setTestWhileIdle(true);
        dataSourceConfig.setTimeBetweenEvictionRunsMillis(1800000);
        dataSourceConfig.setNumTestsPerEvictionRun(3);
        dataSourceConfig.setMinEvictableIdleTimeMillis(1800000);
        dataSourceConfig.setValidationQuery("SELECT version()");

        return dataSourceConfig;
//        return new HikariDataSource(dataSourceConfig);
    }
//Admin: adminxchDkRN
//Password: MTHxddFLCTDJ
    /*public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/Satsang");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("jaySwaminarayan");

        return new HikariDataSource(dataSourceConfig);
    }*/

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.satsang.webapps");
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}