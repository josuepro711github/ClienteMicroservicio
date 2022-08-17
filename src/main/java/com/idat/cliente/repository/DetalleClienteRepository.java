package com.idat.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.cliente.model.ClienteDetalle;

@Repository
public interface DetalleClienteRepository extends JpaRepository<ClienteDetalle, Integer>{

}
