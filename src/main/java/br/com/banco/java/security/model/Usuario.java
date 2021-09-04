package br.com.banco.java.security.model;

import java.lang.annotation.ElementType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.banco.java.annotations.Senha;
import br.com.banco.java.annotations.UsuarioSistema;
import br.com.banco.java.annotations.enumeration.Password;
import br.com.banco.java.annotations.enumeration.UsuarioDoSistema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idUsuario;
	
	@Column
	@UsuarioSistema(usuarioDoSistema = UsuarioDoSistema.usuarioDoSistema)
	private String usuario;
	
	@Column
	@Senha(password = Password.userPassword)
	private String senha;
	
}