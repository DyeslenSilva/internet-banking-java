package br.com.banco.java.service.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "pessoafisica")
public class PessoaFisica extends Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cpf;

	@Column
	private String nConta;
	
	@Column
	private String endereco;
	
	@Column
	private String telefone;
	
	@Column
	private String celular;
	
	@Column
	private String nome;

}
