package com.venturagroup.test;

import com.venturagroup.test.config.ModelMapperConfig;
import com.venturagroup.test.domain.entities.Equipo;
import com.venturagroup.test.domain.repositorios.EquipoRepository;
import com.venturagroup.test.dto.EquipoDto;
import com.venturagroup.test.service.EquipoServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ContextConfiguration(classes = {ModelMapperConfig.class})
public class EquipoTest {

  @InjectMocks
  EquipoServiceImp equipoServiceImp;

  @Spy
  ModelMapper mapper;

  @Mock
  EquipoRepository equipoRepository;


  @Test
  void saveEquipo() {
    Mockito.when(equipoRepository.save(any(Equipo.class))).thenReturn(getEquipo());

    EquipoDto equipoDto = new EquipoDto();

    equipoDto.setId(1);
    equipoDto.setCapacidad("maxima");
    equipoDto.setEstado("Activo");
    equipoDto.setId_estado_equipo(1);
    equipoDto.setId_tipo_equipo(1);
    equipoDto.setCodigo_mantenimiento("2");
    equipoDto.setId_empresa("2");
    equipoDto.setId_pertinencia_equipos(1);
    equipoDto.setMarca("TEST");
    equipoDto.setModelo("TEST0001");
    equipoDto.setNombre("Maquinas");
    equipoDto.setSerial("55224");
    equipoDto.setId_centro_costos("1");
    equipoDto.setId_clasificacion_equipos("1");

    Equipo equi = equipoServiceImp.saveEquipo(equipoDto);

    assertTrue(equi.getId()!=null);
    assertTrue(equi.getNombre().equals("Maquinas"));
  }


  @Test
  void findByEquipo() {
    Mockito.when(equipoRepository.findById(1)).thenReturn(Optional.of(getEquipo()));
    Equipo equi = equipoServiceImp.getEquipo(1);
    assertTrue(equi.getId()!=null);
    assertTrue(equi.getNombre().equals("Maquinas"));
  }


  @Test
  void updateEquipo() {
    Mockito.when(equipoRepository.save(any(Equipo.class))).thenReturn(getEquipo());
    Mockito.when(equipoRepository.findById(1)).thenReturn(Optional.of(getEquipo()));

    EquipoDto equipoDto = new EquipoDto();

    equipoDto.setId(1);
    equipoDto.setCapacidad("maxima");
    equipoDto.setEstado("Activo");
    equipoDto.setId_estado_equipo(1);
    equipoDto.setId_tipo_equipo(1);
    equipoDto.setCodigo_mantenimiento("2");
    equipoDto.setId_empresa("2");
    equipoDto.setId_pertinencia_equipos(1);
    equipoDto.setMarca("TEST");
    equipoDto.setModelo("TEST0001");
    equipoDto.setNombre("Maquinas");
    equipoDto.setSerial("55224");
    equipoDto.setId_centro_costos("1");
    equipoDto.setId_clasificacion_equipos("1");
    Equipo equi = equipoServiceImp.updateEquipo(equipoDto);

    assertTrue(equi.getId()!=null);
    assertTrue(equi.getNombre().equals("Maquinas"));
  }


  public Equipo getEquipo(){
    Equipo equipo = new Equipo();

    equipo.setId(1);
    equipo.setCapacidad("maxima");
    equipo.setEstado("Activo");
    equipo.setId_estado_equipo(1);
    equipo.setId_tipo_equipo(1);
    equipo.setCodigo_mantenimiento("2");
    equipo.setId_empresa("2");
    equipo.setId_pertinencia_equipos(1);
    equipo.setMarca("TEST");
    equipo.setModelo("TEST0001");
    equipo.setNombre("Maquinas");
    equipo.setSerial("55224");
    equipo.setId_centro_costos("1");
    equipo.setId_clasificacion_equipos("1");

    return equipo;
  }


}
