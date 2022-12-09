package com.venturagroup.test.service.dependency;

import com.venturagroup.test.domain.entities.Empresa;
import com.venturagroup.test.dto.EmpresaDto;

public interface EmpresaServiceI {

  Empresa saveEmpresa(EmpresaDto empresaDto);
  Empresa getEmpresa(int id);
  void removeEmpresa(EmpresaDto empresaDto);
  Empresa updateEmpresa(EmpresaDto empresaDto);
}
