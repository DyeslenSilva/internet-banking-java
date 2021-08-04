package br.com.banco.java.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.java.service.model.Cliente;
import br.com.banco.java.service.service.ClienteService;

@RestController
@RequestMapping("/clienteAPI")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(path = "/saveClient",method = RequestMethod.POST)
	public ResponseEntity<Cliente> saveCliente(Cliente cliente){
		boolean save = clienteService.saveClient(cliente);
		if(save ==true) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
}
