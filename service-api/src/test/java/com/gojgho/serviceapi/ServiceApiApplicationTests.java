package com.gojgho.serviceapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceApiApplicationTests {

  @Test
  void contextLoads() {
    System.out.println("TEST");
    Assertions.assertEquals(1L, 1L);
  }

}
