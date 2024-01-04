package com.gojgho.serviceapi.ecommerce.controller;


import com.gojgho.servicecommon.dto.ApiResponse;
import com.gojgho.servicecommon.dto.ApiResponseGenerator;
import com.gojgho.servicedomain.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gojgho.serviceapi.ecommerce.service.UserService;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@Slf4j
@Api("유저 API")
public class UserController {

  private final UserService userService;


  @GetMapping("/find/all")
  @ApiOperation("전체 유저 조회")
  public ApiResponse<List<UserDto>> findAllUsers() {
    List<UserDto> users = userService.findAllUsers();
    return ApiResponseGenerator.success(users);
  }

  @GetMapping("/find/all/querydsl")
  @ApiOperation("전체 유저 QueryDsl 조회")
  public ApiResponse<List<UserDto>> findAll() {
    List<UserDto> users = userService.findAllUsers();
    return ApiResponseGenerator.success(users);
  }

  @GetMapping("/find/cache")
  @ApiOperation("전체 유저 Cache 조회")
  public ApiResponse<List<UserDto>> findUsers() {
    List<UserDto> cacheUsers = userService.findCacheUsers();
    return ApiResponseGenerator.success(cacheUsers);
  }

  @GetMapping("/find/{userEmail}")
  @ApiOperation(value = "email로 특정 유저를 조회")
  public ApiResponse<List<UserDto>> findUserByUserEmail(@PathVariable String userEmail) {
   return ApiResponseGenerator.success(userService.findByUserEmailIsLike(userEmail));
  }

  @PostMapping("/create")
  @ApiOperation(value = "유저 생성")
  public ApiResponse<UserDto> createUser(@RequestBody final UserDto userDto) {
    return ApiResponseGenerator.success(userService.createUser(userDto));
  }

}
