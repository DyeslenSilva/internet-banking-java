package br.com.banco.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.java.service.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepo extends JpaRepository<PessoaFisica, String> {

	void updatePessoaFisica(String cpf);
}
