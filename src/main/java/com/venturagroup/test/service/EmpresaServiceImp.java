package com.venturagroup.test.service;

import com.venturagroup.test.domain.entities.Empresa;
import com.venturagroup.test.domain.repositorios.EmpresaRepository;
import com.venturagroup.test.dto.EmpresaDto;
import com.venturagroup.test.exception.BusinessException;
import com.venturagroup.test.exception.ExceptionFactoryEnums;
import com.venturagroup.test.service.dependency.EmpresaServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImp implements EmpresaServiceI {


  @Autowired
  EmpresaRepository empresaRepository;

  @Autowired
  ModelMapper mapper;


  @Override
  public Empresa saveEmpresa(EmpresaDto empresaDto) {
    Empresa  empresa = mapper.map(empresaDto, Empresa.class);
    return  empresaRepository.save(empresa);
  }

  @Override
  public Empresa getEmpresa(int id) {
    if(empresaRepository.findById(id).isPresent()){
      return empresaRepository.findById(id).get();
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }

  @Override
  public void removeEmpresa(EmpresaDto empresaDto) {
    Empresa  empresa = mapper.map(empresaDto, Empresa.class);
    if(empresaRepository.findById(empresa.getId()).isPresent()){
      empresaRepository.delete(empresa);
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }

  @Override
  public Empresa updateEmpresa(EmpresaDto empresaDto) {
    Empresa  empresa = mapper.map(empresaDto, Empresa.class);
    if(empresaRepository.findById(empresa.getId()).isPresent()){
      return  empresaRepository.save(empresa);
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }
}
