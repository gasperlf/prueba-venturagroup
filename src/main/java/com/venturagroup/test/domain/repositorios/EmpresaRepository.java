package com.venturagroup.test.domain.repositorios;

import com.venturagroup.test.domain.entities.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa,Integer> {
}
