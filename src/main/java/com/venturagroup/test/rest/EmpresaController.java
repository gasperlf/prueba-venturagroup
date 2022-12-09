package com.venturagroup.test.rest;

import com.venturagroup.test.dto.EmpresaDto;
import com.venturagroup.test.service.dependency.EmpresaServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

  @Autowired
  EmpresaServiceI empresaServiceI;

  @Autowired
  ModelMapper mapper;

  @PostMapping(value = "/saveEmpresa")
  public EmpresaDto saveEmpresa(@Valid @RequestBody EmpresaDto empresaDto){
      return mapper.map(empresaServiceI.saveEmpresa(empresaDto),EmpresaDto.class);
  }

  @GetMapping(value ="/getEmpresa")
  public EmpresaDto getEmpresa(@RequestParam("id") int id){
    return mapper.map(empresaServiceI.getEmpresa(id),EmpresaDto.class);
  }


  @PutMapping(value = "/updateEmpresa")
  @Validated
  public EmpresaDto updateEmpresa(@Valid @RequestBody EmpresaDto empresaDto){
    return mapper.map(empresaServiceI.updateEmpresa(empresaDto),EmpresaDto.class);
  }


  @DeleteMapping(value = "/removeEmpresa")
  public void remvoveEmpresa(@Valid @RequestBody EmpresaDto empresaDto){
    empresaServiceI.removeEmpresa(empresaDto);
  }

}
