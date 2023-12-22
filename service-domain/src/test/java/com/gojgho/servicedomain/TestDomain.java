package com.gojgho.servicedomain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 테스트시 java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration
 * 위와같은 에러 발생시  (classes = TestDomain.class)로 실행할 main 메서드 클래스가있는 클래스를 명시해줘야한다.
 */
@SpringBootTest(classes = TestDomain.class)
public class TestDomain {

  public static void main(String[] args) {

  }
  @Test
  void test(){
    System.out.println("TEST");
  }
}
