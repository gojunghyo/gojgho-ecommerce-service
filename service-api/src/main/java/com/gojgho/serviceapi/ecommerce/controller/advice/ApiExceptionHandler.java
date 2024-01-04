package com.gojgho.serviceapi.ecommerce.controller.advice;

import com.gojgho.servicecommon.code.ResponseCode;
import com.gojgho.servicecommon.dto.ApiResponse;
import com.gojgho.servicecommon.dto.ApiResponseGenerator;
import com.gojgho.servicecommon.exception.BusinessException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({
      EntityNotFoundException.class,
      EntityExistsException.class,
      BusinessException.class
  })
  public ApiResponse<Void> handleDataException(BusinessException e) {

    log.error("ApiExceptionHandler > handleDataException > EntityNotFoundException {}", e.getMessage());
    return ApiResponseGenerator.fail(ResponseCode.NO_SUCH_ENTITY_ERROR);
  }


}
