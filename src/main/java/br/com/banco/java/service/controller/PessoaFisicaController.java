package br.com.banco.java.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.java.service.model.PessoaFisica;
import br.com.banco.java.service.service.PessoaFisicaService;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaController {

	private PessoaFisicaService pfService;

	@RequestMapping(path = "/savePF" , method = RequestMethod.POST)
	public ResponseEntity<PessoaFisica> savePessoaFisica(@PathVariable PessoaFisica pessoaFisica,
				BindingResult bindingResult){
		pfService.salvarPessoaFisica(pessoaFisica);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
	}
	
	@RequestMapping(path="/listAllPF" , method = RequestMethod.GET)
	public ResponseEntity<List<PessoaFisica>> listaPessoasFisicas(BindingResult bindingResult){
		pfService.getPessoaFisicaList();
			if(bindingResult.hasErrors()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(pfService.getPessoaFisicaList());
			}
	}
	
	@RequestMapping(path ="/getPF/{cpf}" , method = RequestMethod.GET)
	public ResponseEntity<Optional<PessoaFisica>> getPessoaFisica(@PathVariable String cpf,
			BindingResult bindingResult){
		pfService.getPessoaFisica(cpf);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(pfService.getPessoaFisica(cpf));
		}
	}
	
	@RequestMapping(path = "/updatePF/{cpf}" , method = RequestMethod.PUT)
	public ResponseEntity<PessoaFisica> updatePessoaFisica(@PathVariable String cpf,
			BindingResult bindingResult, PessoaFisica pf){
		pfService.updatePessoaFisica(cpf, pf);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok().build();
		}				
		}
		
	@RequestMapping(path = "/deletePF" , method = RequestMethod.DELETE)
	public ResponseEntity<PessoaFisica> deletePessoaFisica(@PathVariable String cpf,
			BindingResult bindingResult){
			pfService.deletePessoaFisica(cpf);
			if(bindingResult.hasErrors()) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.ok().build();
			}
	}
}