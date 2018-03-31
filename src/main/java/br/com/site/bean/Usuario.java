package br.com.site.bean;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
	@Getter
	@Setter
	@NotBlank(message="Informe o nome.")
	private String nome;
	
	@Getter
	@Setter
	@NotBlank(message="Informe o email.")
	private String email;
	
	@Getter
	@Setter
	@NotBlank(message="Informe a senha.")
	private String senha;


	


}
