package br.com.banco.java.service.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Cliente {

	@Column
	@Id
	private String conta;
	@Column
	private int agencia;
	
	private boolean cadastro;
}