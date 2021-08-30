package br.com.banco.java.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Cliente> saveCliente(@PathVariable Cliente cliente, 
				BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.saveClient(cliente);
			return ResponseEntity.ok().build();
		}
		
	}
	
	@RequestMapping(path = "/clientes" , method = RequestMethod.GET)
	public ResponseEntity<Cliente> getClientes(){
		List<Cliente> clientes = clienteService.getClientes();
		if(clientes.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}else {
			clientes.listIterator();
			return ResponseEntity.ok().build();
		}
	}
	
	
	@RequestMapping(path = "/cliente/{idCliente}" , method = RequestMethod.GET)
	public ResponseEntity<Cliente> getClienteByID(@PathVariable Integer idCliente,
			BindingResult bindingResult){
		Optional<Cliente> clienteByID = clienteService.getCliente(idCliente);
		if(bindingResult.hasErrors() && clienteByID.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			clienteService.getCliente(idCliente);
			return ResponseEntity.ok().build();
		}
	}
	
	@RequestMapping(path = "/cliente/{idCliente}" , method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer idCliente,
			BindingResult bindingResult){
		clienteService.deleteCliente(idCliente);
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			clienteService.deleteCliente(idCliente);
			return ResponseEntity.ok().build();
		}
		
	}
	
	
}
