package com.gojgho.servicecommon.dto;

import com.gojgho.servicecommon.code.ResponseCode;

public class ApiResponseGenerator {

  private static final ApiResponse<Void> RESULT_SUCCESS = new ApiResponse<>(ResponseCode.SUCCESS);
  private static final ApiResponse<Void> RESULT_FAIL = new ApiResponse<>(ResponseCode.FAIL);

  public static ApiResponse<Void> success() {
    return RESULT_SUCCESS;
  }

  public static <D> ApiResponse<D> success(D data) {
    return new ApiResponse<D>(ResponseCode.SUCCESS, null, data);
  }

  public static ApiResponse<Void> fail() {
    return RESULT_FAIL;
  }

  public static <D> ApiResponse<D> fail(D data) {
    return new ApiResponse<>(ResponseCode.FAIL, null, data);
  }

  public static ApiResponse<Void> fail(ResponseCode responseCode) {
    return new ApiResponse(responseCode);
  }
}
