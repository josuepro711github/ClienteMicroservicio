package com.idat.cliente.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_clientes")
public class ClienteDetalle {

	@Id
	private PizzaClienteFk fk = new PizzaClienteFk();

	public PizzaClienteFk getFk() {
		return fk;
	}

	public void setFk(PizzaClienteFk fk) {
		this.fk = fk;
	}
	
}
