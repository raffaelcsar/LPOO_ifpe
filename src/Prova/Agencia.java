package Prova;

public class Agencia {
	
	private String nome;
	private int numero;
	
	public Agencia (String nome, int numero) {
		
		this.nome  = nome;
		this.numero = numero;
	}

	public String getNomeAg() {
		return nome;
	}

	public void setNomeAg(String nome) {
		this.nome = nome;
	}

	public int getNumeroAg() {
		return numero;
	}

	public void setNumeroAg(int numero) {
		this.numero = numero;
	}

}
