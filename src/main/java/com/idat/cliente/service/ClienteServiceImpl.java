package com.idat.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.cliente.client.OpenFeignClient;
import com.idat.cliente.dto.Pizza;
import com.idat.cliente.model.Cliente;
import com.idat.cliente.model.ClienteDetalle;
import com.idat.cliente.model.PizzaClienteFk;
import com.idat.cliente.repository.ClienteRepository;
import com.idat.cliente.repository.DetalleClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private DetalleClienteRepository repositoryDetalle;
	
	@Autowired
	private OpenFeignClient feign;
	
	@Override
	public List<Cliente> listar() {
		return repository.findAll();
	}

	@Override
	public Cliente obtenerId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		repository.saveAndFlush(cliente);
	}

	@Override
	public void asignarPizzaCliente() {
		
		List<Pizza> listado = feign.listarAlumnosSeleccionados();
		PizzaClienteFk fk = null;
		ClienteDetalle detalle = null;
		
		for (Pizza pizza : listado) {
			fk = new PizzaClienteFk();
			fk.setIdPizza(pizza.getIdPizza());;
			fk.setIdCliente(1);
			
			detalle = new ClienteDetalle();
			detalle.setFk(fk);
			
			repositoryDetalle.save(detalle);
		}
		
	}

}












