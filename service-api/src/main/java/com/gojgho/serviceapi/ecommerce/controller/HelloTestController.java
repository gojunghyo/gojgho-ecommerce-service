package com.gojgho.serviceapi.ecommerce.controller;

import com.gojgho.servicecommon.dto.ApiResponse;
import com.gojgho.servicecommon.dto.ApiResponseGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
@Api("헬로 API")
public class HelloTestController {

  @GetMapping
  @ApiOperation(value = "hello 테스트")
  public ApiResponse<String> helloTest() {
    return ApiResponseGenerator.success("Hello world");
  }
}
