package br.com.banco.java.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.java.repo.PessoaFisicaRepo;
import br.com.banco.java.service.model.PessoaFisica;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepo pessoaFisicaRepo;

	
	public void salvarPessoaFisica(PessoaFisica pessoaFisica) {
		pessoaFisicaRepo.save(pessoaFisica);
	}
	
	public List<PessoaFisica> getPessoaFisicaList(){
		return pessoaFisicaRepo.findAll();
	}

	
	public Optional<PessoaFisica> getPessoaFisica(String cpf) {
		return pessoaFisicaRepo.findById(cpf);
	}
	
	public void updatePessoaFisica(String cpf, PessoaFisica pessoaFisica) {
		Optional<PessoaFisica> cadPessoaFisica= getPessoaFisica(cpf);
		if(cadPessoaFisica.isEmpty()) {
			pessoaFisicaRepo.save(pessoaFisica);
		}else {
			pessoaFisicaRepo.updatePessoaFisica(cpf);
		}
	
	}
	
	public void deletePessoaFisica(String cpf) {
		pessoaFisicaRepo.deleteById(cpf);
	}
}
