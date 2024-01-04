package com.gojgho.serviceapi.ecommerce.controller;


import com.gojgho.servicecommon.dto.ApiResponse;
import com.gojgho.servicecommon.dto.ApiResponseGenerator;
import com.gojgho.servicedomain.dto.UserDto;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gojgho.serviceapi.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;


  @RequestMapping("/find/all")
  public ApiResponse<List<UserDto>> findAllUsers() {
    List<UserDto> users = userService.findAllUsers();
    return ApiResponseGenerator.success(users);
  }

  @RequestMapping("/find/all/querydsl")
  public ApiResponse<List<UserDto>> findAll() {
    List<UserDto> users = userService.findAllUsers();
    return ApiResponseGenerator.success(users);
  }

  @RequestMapping("/find/cache")
  public ApiResponse<List<UserDto>> findUsers() {
    List<UserDto> cacheUsers = userService.findCacheUsers();
    return ApiResponseGenerator.success(cacheUsers);
  }

  @RequestMapping("/find/{userEmail}")
  public ApiResponse<List<UserDto>> findUserByUserEmail(@PathVariable String userEmail) {
   return ApiResponseGenerator.success(userService.findByUserEmailIsLike(userEmail));
  }

  @PostMapping("/create")
  public ApiResponse<UserDto> createUser(@RequestBody final UserDto userDto) {
    return ApiResponseGenerator.success(userService.createUser(userDto));
  }

}
