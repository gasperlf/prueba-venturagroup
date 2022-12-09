package com.venturagroup.test.service;

import com.venturagroup.test.domain.entities.Equipo;
import com.venturagroup.test.domain.repositorios.EquipoRepository;
import com.venturagroup.test.dto.EquipoDto;
import com.venturagroup.test.exception.BusinessException;
import com.venturagroup.test.exception.ExceptionFactoryEnums;
import com.venturagroup.test.service.dependency.EquipoServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoServiceImp implements EquipoServiceI {

  @Autowired
  EquipoRepository equipoRepository;

  @Autowired
  ModelMapper mapper;

  @Override
  public Equipo saveEquipo(EquipoDto equipoDto) {
    return equipoRepository.save(mapper.map(equipoDto, Equipo.class));
  }

  @Override
  public Equipo getEquipo(int id) {
    if(equipoRepository.findById(id).isPresent()){
      return equipoRepository.findById(id).get();
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }

  @Override
  public void removeEquipo(EquipoDto equipoDto) {
    Equipo equipo = mapper.map(equipoDto, Equipo.class);
    if(equipoRepository.findById(equipo.getId()).isPresent()){
      equipoRepository.delete(equipo);
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }

  @Override
  public Equipo updateEquipo(EquipoDto equipoDto) {
    Equipo equipo = mapper.map(equipoDto, Equipo.class);
    if(equipoRepository.findById(equipo.getId()).isPresent()){
      return equipoRepository.save(equipo);
    }else {
      throw new BusinessException(ExceptionFactoryEnums.BUSINESS.getInfo(), ExceptionFactoryEnums.BAD_REQUEST.getInfo());
    }
  }
}
