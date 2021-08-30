package br.com.banco.java.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.java.repo.PessoaJuridicaRepo;
import br.com.banco.java.service.model.PessoaJuridica;

@Service
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaRepo pessoaJuridicaRepo;

	public void savePJ(PessoaJuridica pessoaJuridica) {
		pessoaJuridicaRepo.saveAndFlush(pessoaJuridica);
	}
	
	public List<PessoaJuridica> listaPessoaJuridica(){
		return pessoaJuridicaRepo.findAll();
	}
	
	public Optional<PessoaJuridica> pessoaJuridicaPorCNPJ(String cnpj) {
		return pessoaJuridicaRepo.findById(cnpj);
	}
	
	public void updatePessoaJuridica(String cnpj, PessoaJuridica pj) {
		Optional<PessoaJuridica> pessoaJuridica = pessoaJuridicaRepo.updatePessoaJuridica(cnpj);
		if(pessoaJuridica.isEmpty()) {
			pessoaJuridicaRepo.saveAndFlush(pj);
		}else {
			pessoaJuridicaRepo.updatePessoaJuridica(cnpj);
		}
	}
	
	public void deletePessoaJuridica(String cnpj) {
		pessoaJuridicaRepo.deleteById(cnpj);
	}
}
