package br.com.banco.java.service.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.java.service.model.Cliente;

public interface ClienteRepo  extends JpaRepository<Cliente, Integer>{

}
