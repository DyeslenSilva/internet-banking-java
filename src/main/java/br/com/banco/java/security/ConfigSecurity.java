package br.com.banco.java.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.banco.java.service.model.Cliente;
import br.com.banco.java.service.service.ClienteService;
import br.com.banco.java.service.service.PessoaFisicaService;
import br.com.banco.java.service.service.PessoaJuridicaService;

@Configuration
@EnableConfigurationProperties
public class ConfigSecurity<T>  extends WebSecurityConfigurerAdapter {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PessoaFisicaService pessoaFisicaService;
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	@Autowired	
	private Cliente cliente;
	
	//private MyUserDetailsService user;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/banco-java/**")
			.permitAll().antMatchers(HttpMethod.GET).permitAll()
			.antMatchers(HttpMethod.GET).hasRole(cliente.getResponsavel())
			.antMatchers(HttpMethod.GET).hasRole(cliente.getConta())
			.and().csrf().disable().headers().frameOptions().disable();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService((T) pessoaFisicaService).passwordEncoder(new BCryptPasswordEncoder());
		super.configure(auth);
	}


}
