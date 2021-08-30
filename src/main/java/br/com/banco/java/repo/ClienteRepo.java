package br.com.banco.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.java.service.model.Cliente;
import br.com.banco.java.service.model.PessoaFisica;
import br.com.banco.java.service.model.PessoaJuridica;

public interface ClienteRepo  extends JpaRepository<Cliente, Integer>{

}