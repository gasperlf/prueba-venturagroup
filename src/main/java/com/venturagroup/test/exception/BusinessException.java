package com.venturagroup.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException{

  private String typeException;
  private String message;

  public BusinessException(String typeException,String message) {
    this.message = message;
    this.typeException = typeException;
  }

  public String getTypeException() {
    return typeException;
  }

  public void setTypeException(String typeException) {
    this.typeException = typeException;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
