package com.gojgho.serviceapi.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce")
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
