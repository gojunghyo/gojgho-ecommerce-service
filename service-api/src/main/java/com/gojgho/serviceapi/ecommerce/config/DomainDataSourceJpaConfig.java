package com.gojgho.serviceapi.ecommerce.config;

import static com.gojgho.serviceapi.ecommerce.config.DomainDataSourceJpaConfig.ECOMMERCE_DOMAIN_ENTITY_MANAGER_FACTORY;
import static com.gojgho.serviceapi.ecommerce.config.DomainDataSourceJpaConfig.ECOMMERCE_DOMAIN_PACKAGE;
import static com.gojgho.serviceapi.ecommerce.config.DomainDataSourceJpaConfig.ECOMMERCE_DOMAIN_TRANSACTION_MANAGER;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = {ECOMMERCE_DOMAIN_PACKAGE}, //또는 basePackageClasses = DomainMarker.class 가능
    transactionManagerRef = ECOMMERCE_DOMAIN_TRANSACTION_MANAGER,
    entityManagerFactoryRef = ECOMMERCE_DOMAIN_ENTITY_MANAGER_FACTORY
)
@Configuration
public class DomainDataSourceJpaConfig {

  public static final String ECOMMERCE_DOMAIN_PACKAGE = "com.gojgho.servicedomain";
  public static final String ECOMMERCE_DOMAIN_TRANSACTION_MANAGER = "ecommerceDomainTransactionManager";
  public static final String ECOMMERCE_DOMAIN_ENTITY_MANAGER_FACTORY = "ecommerceDomainEntityManagerFactory";

  public static final String ECOMMERCE_DOMAIN_JPA_PROPERTIES = "ecommerceDomainJpaProperties";
  public static final String ECOMMERCE_DOMAIN_HIBERNATE_PROPERTIES = "ecommerceDomainHibernateProperties";
  public static final String ECOMMERCE_DOMAIN_DATA_SOURCE = "ecommerceDomainDataSource";

  public static final String ECOMMERCE_DOMAIN_PERSIST_UNIT = "ecommerceDomain";
  public static final String ECOMMERCE_DOMAIN_JDBC_TEMPLATE = "ecommerceDomainJdbcTemplate";

  @Bean(name = ECOMMERCE_DOMAIN_ENTITY_MANAGER_FACTORY)
  public LocalContainerEntityManagerFactoryBean ecommerceDomainEntityManagerFactory() {
    log.info("JpaProperties => {}", this.ecommerceDomainJpaProperties().getProperties());
    return new EntityManagerFactoryBuilder(
        new HibernateJpaVendorAdapter(), this.ecommerceDomainJpaProperties().getProperties(), null)
        .dataSource(this.ecommerceDomainDataSource())
        .properties(this.ecommerceDomainHibernateProperties()
            .determineHibernateProperties(this.ecommerceDomainJpaProperties().getProperties(), new HibernateSettings()))
        .persistenceUnit(ECOMMERCE_DOMAIN_PERSIST_UNIT)
        .packages(ECOMMERCE_DOMAIN_PACKAGE)
        .build();
  }

  @Bean(name = ECOMMERCE_DOMAIN_JPA_PROPERTIES)
  @ConfigurationProperties(prefix = "ecommerce.domain.jpa")
  public JpaProperties ecommerceDomainJpaProperties() {
    return new JpaProperties();
  }

  @Bean(name = ECOMMERCE_DOMAIN_HIBERNATE_PROPERTIES)
  @ConfigurationProperties(prefix = "ecommerce.domain.jpa.hibernate")
  public HibernateProperties ecommerceDomainHibernateProperties() {
    return new HibernateProperties();
  }

  @Bean(name = ECOMMERCE_DOMAIN_DATA_SOURCE)
  @ConfigurationProperties(prefix = "ecommerce.domain.datasource")
  public DataSource ecommerceDomainDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  /// 부수적인 요소
  @Bean(name = ECOMMERCE_DOMAIN_TRANSACTION_MANAGER)
  public PlatformTransactionManager ecommerceDomainTransactionManager(
      @Autowired @Qualifier(ECOMMERCE_DOMAIN_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean(name = ECOMMERCE_DOMAIN_JDBC_TEMPLATE)
  public JdbcTemplate ecommerceDomainJdbcTemplate(
      @Qualifier("ecommerceDomainDataSource") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
