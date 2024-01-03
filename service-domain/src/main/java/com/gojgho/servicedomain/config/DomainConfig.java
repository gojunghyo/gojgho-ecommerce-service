package com.gojgho.servicedomain.config;

import com.gojgho.servicedomain.DomainMarker;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackageClasses = DomainMarker.class) //이코드로 인해서 domain 에있는 cache component 를 스캔할수있음
@EntityScan(basePackageClasses = DomainMarker.class) //domain entity 가져옴 com.gojgho.servicedomain
public class DomainConfig {

}
