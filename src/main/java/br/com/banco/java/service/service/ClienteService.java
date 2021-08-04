package br.com.banco.java.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import br.com.banco.java.service.data.ClienteRepo;
import br.com.banco.java.service.model.Cliente;

@Service
public class ClienteService {
 
	@Autowired
	private ClienteRepo clienteRepo;
	
	public boolean saveClient(Cliente cliente) {
		boolean saveCliente = clienteRepo.save(cliente) != null;
		return saveCliente;
	}
	
	public List<Cliente> getClientes(){
		return clienteRepo.findAll();
	}
	
	public Optional<Cliente> getCliente(Integer idCliente) {
		Optional<Cliente> cliente =clienteRepo.findById(idCliente);
		return cliente;
	}
	
	public void deleteCliente(Integer idCliente) {
		clienteRepo.deleteById(idCliente);
	}
}