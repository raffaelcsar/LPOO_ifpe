package Prova;

public class Poupanca extends Conta {
	
	private double juros;
		
	public Poupanca(int numero, double saldo, Agencia banco, Cliente usuario, double juros) {
		super(numero, saldo, banco, usuario);
		
		this.juros = juros;
		
	}
	

	public double getJuros() {
		return juros;
	}


	public void setJuros(double juros) {
		this.juros = juros;
	}


	public void renderJuros() {
		this.setSaldo((this.getSaldo() * (1 + this.juros)));
		
		
	}
	


}