package com.gojgho.servicecommon.dto;

import com.gojgho.servicecommon.code.ResponseCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResponse<T> {

  private String code;
  private String message;
  private T data;

  ApiResponse(ResponseCode errorCode) {
    this(errorCode, errorCode.getDefaultMessage(), null);
  }

  public ApiResponse(ResponseCode errorCode, String message, T data) {
    this.code = errorCode.getCode();
    this.message = errorCode.getDefaultMessage();
    this.data = data;
  }

  public ApiResponse(ResponseCode responseCode, String message) {
    this.code = responseCode.getCode();
    this.message = message;
  }
}
