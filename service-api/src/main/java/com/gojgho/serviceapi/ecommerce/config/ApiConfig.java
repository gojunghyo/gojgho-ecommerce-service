package com.gojgho.serviceapi.ecommerce.config;

import com.gojgho.servicedomain.config.DomainConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//domain 클래스에 bean, componet 등을 가져옴
@Configuration
@Import(DomainConfig.class) //import 어노테이션으로 인해서 datasourceJpaConfig 클래스 등을 가져올수있음
public class ApiConfig {

}
