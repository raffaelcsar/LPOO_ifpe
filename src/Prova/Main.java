package Prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Conta> database = new ArrayList<>();

	public static void cadastroContaCorrente() {
		Scanner scan = new Scanner(System.in);
		if (database.size() >= 10) {
			System.out.println("ERRO! N�o H� Mais Espa�o No Sistema. :( ");
		} else {
		
		System.out.println("Digite o Nome do cliente: ");
		String nome = scan.nextLine();
		System.out.println("Digite o CPF do cliente: ");
		long cpf = scan.nextLong();
		scan.nextLine();
		System.out.println("Digite no nome do Banco: ");
		String nomeAg = scan.nextLine();
		System.out.println("Digite o n�mero do Ag�ncia:  ");
		int numeroAg = scan.nextInt();
		System.out.println("Digite o n�mero da conta: ");
		int numero = scan.nextInt();
		System.out.println("Digite o saldo inicial: ");
		double saldo = scan.nextDouble();
		database.add(new Conta(numero, saldo, new Agencia(nomeAg, numeroAg), new Cliente(nome, cpf)));
	}
	}

	public static void cadastroContaPopanca() {
		Scanner scan = new Scanner(System.in);
		if (database.size() >= 10) {
			System.out.println("ERRO! N�o H� Mais Espa�o No Sistema. :( ");
		} else {
		System.out.println("Digite o Nome do cliente: ");
		String nomeP = scan.nextLine();
		System.out.println("Digite o CPF do cliente: ");
		long cpfP = scan.nextLong();
		scan.nextLine();
		System.out.println("Digite no nome do Banco: ");
		String nomeAgP = scan.nextLine();
		System.out.println("Digite o n�mero da Ag�ncia:  ");
		int numeroAgP = scan.nextInt();
		System.out.println("Digite o n�mero da conta: ");
		int numeroP = scan.nextInt();
		System.out.println("Digite o saldo inicial: ");
		double saldoP = scan.nextDouble();
		System.out.println("Digite a taxa de Juros da sua conta: ");
		Double juros = scan.nextDouble();

		database.add(new Poupanca(numeroP, saldoP, new Agencia(nomeAgP, numeroAgP), new Cliente(nomeP, cpfP), juros));
		;
		}
	}

	public static void fazerDeposito() {

		Scanner scan = new Scanner(System.in);
		boolean achado = false;
		boolean flag = true;
		do {
			System.out.println("Digite o CPF da Pessoa para deposito");
			long cpfBusca = scan.nextLong();
			for (int i = 0; i < database.size(); i++) {
				Cliente c = database.get(i).getUsuario();
				if (cpfBusca == c.getCpf()) {
					System.out.println("Digite o valor desejado: ");
					double valor = scan.nextInt();

					if (valor <= 0) {
						System.out.println("Digite apenas valores positivos!");
						break;
					} else {
						database.get(i).deposito(valor);
						System.out.println(database.get(i).getSaldo());
						flag = false;

					}

				}
			}

		} while (flag);

	}

	public static void taxaJuros() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println("Digite o CPF da Pessoa para deposito");
			long cpfBusca = scan.nextLong();
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i) instanceof Poupanca) {
					Poupanca p = (Poupanca) database.get(i);
					p.renderJuros();
					System.out.println("Seu saldo com o juros � de: " + p.getSaldo());
					flag = false;
				}
			}
		} while (flag);

	}

	public static void numNomeAgencia() {
		boolean flag1 = false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o CPF da Pessoa para deposito");
			long cpfBusca2 = scan.nextLong();
			scan.nextLine();
			for (int i = 0; i < database.size(); i++) {
				Cliente c = database.get(i).getUsuario();
				Agencia a = database.get(i).getBanco();
				if (cpfBusca2 == c.getCpf()) {

					System.out.println("CPF: " + c.getCpf());
					System.out.println("Nome: " + c.getNome());
					System.out.println("Sua ag�ncia �:" + a.getNomeAg());
					System.out.println("O N� da sua ag�ncia �:" + a.getNumeroAg());
					flag1 = false;

				}
			}
		} while (flag1);
	}

	public static void alterar() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o Nome da Pessoa altera��o");
		String alterar = scan.nextLine();
		for (int i = 0; i < database.size(); i++) {
			Cliente c = database.get(i).getUsuario();
			if (alterar.contains(c.getNome())) {
				Agencia a = database.get(i).getBanco();
				System.out.println("Digite o novo nome da Ag�ncia: ");
				String novaAg = scan.nextLine();
				a.setNomeAg(novaAg);
				System.out.println("Digite o novo n�mero da Ag�ncia: ");
				int novoNumAg = scan.nextInt();
				a.setNumeroAg(novoNumAg);

			}
		}
	}

	public static void metodoPrincipal() {

		boolean flag = true;
		do {
			try {

				Scanner scan = new Scanner(System.in);
				System.out.println("1. Cadastrar Conta ou Poupan�a");
				System.out.println("2. Realizar dep�sito");
				System.out.println("3. Render Juros");
				System.out.println("4. Consultar n�mero e nome da ag�ncia");
				System.out.println("5. Alterar o n�mero e nome da ag�ncia");
				System.out.println("0. Sair");

				int key = scan.nextInt();
				switch (key) {

				case 1:
					boolean flagContas = true;
					do {
						try {

							System.out.println("Qual conta deseja criar:");
							System.out.println("1. Conta Corrente");
							System.out.println("2. Conta Poupan�a");
							int key1 = scan.nextInt();
							switch (key1) {

							case 1:
								cadastroContaCorrente();
								flagContas = false;
								break;

							case 2:
								cadastroContaPopanca();
								flagContas = false;
								break;
							}
						} catch (Exception e) {
							System.out.println("Op��o inv�lida! Tente novamente");
						}

					} while (flagContas);
					break;

				case 2:
					fazerDeposito();
					break;

				case 3:
					taxaJuros();

					break;

				case 4:
					numNomeAgencia();
					break;
				case 5:
					alterar();

					break;

				case 0:
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("Op��o inv�lida! Tente novamente.");
			}

		} while (flag);

	}

	public static void main(String[] args) {
		
		metodoPrincipal();
		
	}
}