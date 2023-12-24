package com.gojgho.serviceapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServiceApiApplicationTests.class)
class ServiceApiApplicationTests {

  @Test
  void contextLoads() {
    System.out.println("TEST");
    Assertions.assertEquals(1L, 1L);
  }

}
