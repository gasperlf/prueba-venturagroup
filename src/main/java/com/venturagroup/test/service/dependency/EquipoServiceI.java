package com.venturagroup.test.service.dependency;

import com.venturagroup.test.domain.entities.Equipo;
import com.venturagroup.test.dto.EquipoDto;

public interface EquipoServiceI {

  Equipo saveEquipo(EquipoDto equipoDto);
  Equipo getEquipo(int id);
  void removeEquipo(EquipoDto equipoDto);
  Equipo updateEquipo(EquipoDto equipoDto);
}
