package com.venturagroup.test.rest;

import com.venturagroup.test.dto.EquipoDto;
import com.venturagroup.test.service.dependency.EquipoServiceI;
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
@RequestMapping("/equipos")
public class EquipoController {

  @Autowired
  EquipoServiceI equipoServiceI;

  @Autowired
  ModelMapper mapper;

  @PostMapping(value = "/saveEquipo")
  public EquipoDto saveEquipo(@Valid @RequestBody EquipoDto equipoDto){
    return mapper.map(equipoServiceI.saveEquipo(equipoDto),EquipoDto.class);
  }

  @GetMapping(value ="/getEquipo")
  public EquipoDto getEquipo(@RequestParam("id") int id){
    return mapper.map(equipoServiceI.getEquipo(id),EquipoDto.class);
  }


  @PutMapping(value = "/updateEquipo")
  @Validated
  public EquipoDto updateEquipo(@Valid @RequestBody EquipoDto equipoDto){
    return mapper.map(equipoServiceI.updateEquipo(equipoDto),EquipoDto.class);
  }


  @DeleteMapping(value = "/removeEquipo")
  public void remvoveEquipo(@Valid @RequestBody EquipoDto equipoDto){
    equipoServiceI.removeEquipo(equipoDto);
  }

}
