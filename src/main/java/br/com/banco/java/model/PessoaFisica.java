package br.com.banco.java.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaFisica extends Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;

	private String endereco;
	
	private String telefone;
	private String celular;

}
