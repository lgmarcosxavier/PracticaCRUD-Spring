package com.spring.crud.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.modelo.entidad.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
