package com.gojgho.serviceapi.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  /**
   * @URL: http://localhost:9090/swagger-ui/index.html
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
        .apiInfo(this.apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any()) //Swagger API 문서로 만들기 API 메서드들이 작성되어 있는 패키지
        .paths(PathSelectors.ant("/v1/**"))
        .build();
  }

  // Swagger API 문서에 대한 설명을 표기하는 메서드.
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Ecommerce Service Rest API Documentation")
        .description("gojgho Side Project")
        .version("0.1")
        .build();
  }
}
