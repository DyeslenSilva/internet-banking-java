package br.com.banco.java.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.java.service.model.PessoaJuridica;
import br.com.banco.java.service.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pjAPI")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	
	@RequestMapping(path = "/salvarPJ" , method = RequestMethod.POST)
	public ResponseEntity<PessoaJuridica> salvarPessoaJuridica(@PathVariable PessoaJuridica pessoaJuridica,
			BindingResult bindingResult){

		pessoaJuridicaService.savePJ(pessoaJuridica);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}


	@RequestMapping(path = "/listaPessoasJuridicas" , method = RequestMethod.GET)
	public ResponseEntity<List<PessoaJuridica>> listaPessoaJuridica(BindingResult bindingResult){
		pessoaJuridicaService.listaPessoaJuridica();
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(pessoaJuridicaService.listaPessoaJuridica());
		}
	}
	
	@RequestMapping(path = "/pessoaJuridica/{cnpj}" , method = RequestMethod.GET)
	public ResponseEntity<Optional<PessoaJuridica>> pessoaJuridicaPorCNPJ(String cnpj,
			BindingResult bindingResult){
		pessoaJuridicaService.pessoaJuridicaPorCNPJ(cnpj);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(pessoaJuridicaService.pessoaJuridicaPorCNPJ(cnpj));
		}
	}
	
	@RequestMapping(path = "/pessoaJuridica/{cnpj}" , method = RequestMethod.PUT)
	public ResponseEntity<PessoaJuridica> atualizarPessoaJuridica(String cnpj, BindingResult bindingResult,
			PessoaJuridica pj){
		pessoaJuridicaService.updatePessoaJuridica(cnpj, pj);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
	
	@RequestMapping(path = "/pessoaJuridica/{cnpj}" , method = RequestMethod.DELETE)
	public ResponseEntity<PessoaJuridica> deletarPessoaJuridica(String cnpj, BindingResult bindingResult){
		pessoaJuridicaService.deletePessoaJuridica(cnpj);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
}