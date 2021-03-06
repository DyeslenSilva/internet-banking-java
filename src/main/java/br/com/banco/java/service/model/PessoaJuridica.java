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
@Table(name = "pessoajuridica")
public class PessoaJuridica extends Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cnpj;
	
	@Column
	private Integer nConta;
	
	
	@Column
	private String endereco;
	
	@Column
	private String telefoneComercial;
	
	@Column
	private String nomeFantasia;
}
