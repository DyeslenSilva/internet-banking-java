package br.com.banco.java.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.java.service.model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepo extends JpaRepository<PessoaJuridica, String> {

	public Optional<PessoaJuridica> updatePessoaJuridica(String cnpj);
}
