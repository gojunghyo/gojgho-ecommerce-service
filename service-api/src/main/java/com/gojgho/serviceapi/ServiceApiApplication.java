package com.gojgho.serviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.gojgho.servicedomain"})
@EnableJpaRepositories(basePackages = {"com.gojgho.servicedomain"})
public class ServiceApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceApiApplication.class, args);
  }

}
