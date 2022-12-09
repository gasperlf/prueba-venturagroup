package com.venturagroup.test.dto;

import javax.validation.constraints.NotNull;

public class EmpresaDto {

  @NotNull(message = "El id no pueder nulo")
  private Integer id;

  @NotNull(message = "El códgo no pueder nulo")
  private String codigo;

  @NotNull(message = "El nit no pueder nulo")
  private String nit   ;

  @NotNull(message = "El nombre no pueder nulo")
  private String nombre;

  @NotNull(message = "El estado no pueder nulo")
  private String estado;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNit() {
    return nit;
  }

  public void setNit(String nit) {
    this.nit = nit;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
