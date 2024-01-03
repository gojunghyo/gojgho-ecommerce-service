package com.gojgho.serviceapi.ecommerce.config;

import com.gojgho.servicedomain.DomainMarker;
import com.gojgho.servicedomain.config.DomainConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//domain 클래스에 db 정보와 cache 등을 가져옴
@Configuration
@ComponentScan(basePackageClasses = DomainMarker.class) //이코드로 인해서 domain 에있는 cache component 를 스캔할수있음
//import 어노테이션으로 인해서 datasourceJpaConfig 클래스 등을 가져올수있음
@Import(DomainConfig.class)
public class ApiConfig {

}
