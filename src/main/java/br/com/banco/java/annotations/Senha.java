package br.com.banco.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.banco.java.annotations.enumeration.Password;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Senha {

	Password password();
}
