package com.gojgho.servicedomain.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayMigrationStrategyConfig {
  //todo 제거해도될듯
  @Bean
  public FlywayMigrationStrategy cleanMigrateStrategy() {
    return flyway -> {
      flyway.repair();
      flyway.migrate();
    };
  }
}
