package com.idat.cliente.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.cliente.dto.Pizza;

@FeignClient(name = "idat-pizza", url = "localhost:8090")
public interface OpenFeignClient {
	
	@GetMapping("EF-Josue-Cisneros/pizza/listar")
	List<Pizza> listarAlumnosSeleccionados();
	
}
