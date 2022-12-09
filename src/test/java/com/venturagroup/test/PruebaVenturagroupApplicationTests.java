package com.venturagroup.test;

import com.venturagroup.test.config.ModelMapperConfig;
import com.venturagroup.test.domain.entities.Empresa;
import com.venturagroup.test.domain.repositorios.EmpresaRepository;
import com.venturagroup.test.domain.repositorios.EquipoRepository;
import com.venturagroup.test.dto.EmpresaDto;
import com.venturagroup.test.exception.BusinessException;
import com.venturagroup.test.service.EmpresaServiceImp;
import com.venturagroup.test.service.EquipoServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
@ContextConfiguration(classes = {ModelMapperConfig.class})
class PruebaVenturagroupApplicationTests {

    @InjectMocks
    EmpresaServiceImp empresaServiceImp;

    @Spy
    ModelMapper mapper;

    @Mock
    EmpresaRepository empresaRepository;



    @Test
    void saveEmpresa() {
        Mockito.when(empresaRepository.save(any(Empresa.class))).thenReturn(getEmpresa());

        EmpresaDto empresaDto =  new EmpresaDto();
        empresaDto.setCodigo("01");
        empresaDto.setEstado("activo");
        empresaDto.setId(1);
        empresaDto.setNit("4568789");
        empresaDto.setNombre("Pruebas");
        Empresa emp = empresaServiceImp.saveEmpresa(empresaDto);

        assertTrue(emp.getId()!=null);
        assertTrue(emp.getNombre().equals("Pruebas"));
    }


    @Test
    void findByEmpresa() {
        Mockito.when(empresaRepository.findById(1)).thenReturn(Optional.of(getEmpresa()));
        Empresa emp = empresaServiceImp.getEmpresa(1);
        assertTrue(emp.getId()!=null);
        assertTrue(emp.getNombre().equals("Pruebas"));
    }


    @Test
    void updateEmpresa() {
        Mockito.when(empresaRepository.save(any(Empresa.class))).thenReturn(getEmpresa());
        Mockito.when(empresaRepository.findById(1)).thenReturn(Optional.of(getEmpresa()));

        EmpresaDto empresaDto =  new EmpresaDto();
        empresaDto.setCodigo("01");
        empresaDto.setEstado("activo");
        empresaDto.setId(1);
        empresaDto.setNit("4568789");
        empresaDto.setNombre("Pruebas");
        Empresa emp = empresaServiceImp.updateEmpresa(empresaDto);

        assertTrue(emp.getId()!=null);
        assertTrue(emp.getNombre().equals("Pruebas"));
    }

    /*@Test
    void deleteEmpresa() {
        Mockito.when(empresaRepository.findById(1)).thenReturn(Optional.of(getEmpresa()));

        EmpresaDto empresaDto =  new EmpresaDto();
        empresaDto.setCodigo("01");
        empresaDto.setEstado("activo");
        empresaDto.setId(1);
        empresaDto.setNit("4568789");
        empresaDto.setNombre("Pruebas");
        empresaServiceImp.removeEmpresa(empresaDto);

        verify(empresaRepository, times(1)).delete(getEmpresa());

    }*/

    public Empresa getEmpresa(){
        Empresa empresa = new Empresa();
        empresa.setCodigo("01");
        empresa.setEstado("activo");
        empresa.setId(1);
        empresa.setNit("4568789");
        empresa.setNombre("Pruebas");

        return empresa;
    }


}
