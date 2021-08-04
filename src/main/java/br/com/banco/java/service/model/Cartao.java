package br.com.banco.java.service.model;

import javax.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cartao extends Cliente{

	
	@Column
	private Integer nCartao;
	
	@Column
	private String bandeira;
	
	
	private Integer codigoDeSeguranca;
	
	private Integer senha;
	
}
