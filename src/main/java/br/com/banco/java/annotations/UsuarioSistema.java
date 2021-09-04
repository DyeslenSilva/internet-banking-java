package br.com.banco.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.banco.java.annotations.enumeration.Password;
import br.com.banco.java.annotations.enumeration.UsuarioDoSistema;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsuarioSistema {
	
	UsuarioDoSistema usuarioDoSistema();
	//Password senha();
}
