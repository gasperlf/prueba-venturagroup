package com.venturagroup.test.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
@ResponseBody
public class HttpExceptionsHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public final ResponseEntity<Object> handleTecnicalException(Exception ex, WebRequest request){
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage() + ex.getStackTrace()[0]);
    ErrorResponse error = new ErrorResponse("TechnicalException", details);
    return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResponseEntity<Object> handleException(BusinessException ex) {
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());
    ErrorResponse error = new ErrorResponse(ex.getTypeException().equals(ExceptionFactoryEnums.BUSINESS.getInfo())?ExceptionFactoryEnums.BUSINESS.getInfo():ExceptionFactoryEnums.TECHNICAL.getInfo(), details);
    return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request) {
    String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
    List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(
            Collectors.toList());

    List<String> details = new ArrayList<>();
    details.addAll(validationList);
    ErrorResponse error = new ErrorResponse(ExceptionFactoryEnums.BUSINESS.getInfo(),details);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

  }

}
