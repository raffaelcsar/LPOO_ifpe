package Prova;

public class Conta {

	private int numero;
	private double saldo;
	private Agencia banco;
	private Cliente usuario;

	public Conta(int numero, double saldo, Agencia banco, Cliente usuario) {
		
		this.numero = numero;
		this.saldo = saldo;
		this.banco = banco;
		this.usuario = usuario;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Agencia getBanco() {
		return banco;
	}

	public void setBanco(Agencia banco) {
		this.banco = banco;
	}

	public Cliente getUsuario() {
		return usuario;
	}

	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}

	public void deposito(double valor) {
		this.saldo += valor;
	}
}
