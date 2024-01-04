package com.gojgho.servicecommon.exception;

import com.gojgho.servicecommon.code.ResponseCode;

public class BusinessException extends RuntimeException {

  private ResponseCode errorCode;

  public BusinessException(ResponseCode errorCode) {
    super(errorCode.name());
    this.errorCode = errorCode;
  }

  public BusinessException(String message) {
    super(message);
  }


}
