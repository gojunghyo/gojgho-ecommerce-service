package com.gojgho.serviceapi.ecommerce.controller;


import com.gojgho.servicedomain.dto.UserDto;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gojgho.serviceapi.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;


  @RequestMapping("/find/all")
  public ResponseEntity<List<UserDto>> findAllUsers() {
    List<UserDto> users = userService.findAllUsers();
    return ResponseEntity.ok().body(users);
  }

  @RequestMapping("/find/all/querydsl")
  public ResponseEntity<List<UserDto>> findAll() {
    List<UserDto> users = userService.findAllUsers();
    return ResponseEntity.ok().body(users);
  }

}
