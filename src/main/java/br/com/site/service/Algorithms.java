package br.com.site.service;

public enum Algorithms {

	MD5("MD5"),SHA1("SHA-1"),SHA2("SHA-256"),SHA5("SHA-512");
	private String algorithms;
	
	Algorithms(String algorithms){
		this.algorithms = algorithms;
	}
	
	public String getAlgorithms() {
		return algorithms;
	}
}
