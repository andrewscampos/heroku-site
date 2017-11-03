package br.com.pine.bean;

import org.hibernate.validator.constraints.NotBlank;

public class Push {
	
	@NotBlank(message="CustomerId inválido.")
	private String customerId;
	
	@NotBlank(message="Menssagem inválida.")
	private String menssagem;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
	
	
}
