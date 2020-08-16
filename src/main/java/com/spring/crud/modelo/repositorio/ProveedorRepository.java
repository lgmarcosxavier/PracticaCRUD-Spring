package com.spring.crud.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.modelo.entidad.Proveedor;

@Repository // marcar la clase como intermedia a una bd como encapsulador de datos
public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{

}
