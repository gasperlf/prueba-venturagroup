package com.venturagroup.test.exception;

public enum ExceptionFactoryEnums {
  BUSINESS("BusinessException"),
  TECHNICAL("TechnicalException"),
  BAD_REQUEST("No se encontraron datos"),
  ERROR_SAVE("Error guardando entidad");


  private String info;

  ExceptionFactoryEnums(String info) {
    this.info = info;
  }

  public String getInfo() {
    return info;
  }
}
