package br.com.banco.java.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

import br.com.banco.java.annotations.enumeration.DadosCartao;
import br.com.banco.java.annotations.enumeration.Password;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cartao {
	DadosCartao[] numeroCartao();
	DadosCartao[] bandeira();
	Password[] senha();
	
}
