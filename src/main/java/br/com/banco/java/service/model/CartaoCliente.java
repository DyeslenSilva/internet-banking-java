package br.com.banco.java.service.model;

import javax.persistence.Column;

import br.com.banco.java.annotations.Cartao;
import br.com.banco.java.annotations.Senha;
import br.com.banco.java.annotations.enumeration.DadosCartao;
import br.com.banco.java.annotations.enumeration.Password;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class CartaoCliente extends Cliente{

	
	@Column
	private Integer nCartao;
	
	@Column
	private String bandeira;

	@Cartao(bandeira = DadosCartao.bandeira,  numeroCartao = DadosCartao.nCartao)
	private Integer codigoDeSeguranca;
	
	@Senha(password = Password.cardPassword)
	private Integer senha;
	
}
