/**
 * 
 */
package banco_itabaiana;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		ArrayList<Conta> contas = new ArrayList<Conta>();
		
		
		Scanner teclado = new Scanner(System.in);
		int id = 0;
		
		// 1º Fazer login ou criar conta
		while (true) {
			int escolha = menuInicial(teclado);
			if (escolha == 9) {
				System.out.println("Encerrando programa...");
				break;
			} else if ((escolha < 0) || (escolha > 2 && escolha < 9) || (escolha > 9)) {
				System.out.println("Opcao Invalida!");
			} else if (escolha == 1) {
				Cliente novoCliente = criarCliente(teclado);
				int tipoConta = tipoConta(teclado);
				id++;
				if (tipoConta == 1) {
					ContaCorrente novaConta = new ContaCorrente(id, novoCliente);
					contas.add(novaConta);
				} else {
					ContaPoupanca novaConta = new ContaPoupanca(id, novoCliente);
					contas.add(novaConta);
				}
				System.out.println("Conta criada com sucesso!");
			} else if (escolha == 2) {
				Conta loginUsuario = fazerLogin(teclado, contas);
				if (loginUsuario != null && loginUsuario.isStatus()) { // Cliente logado
					while (true) {
						menuConta(teclado, loginUsuario);
						int opcao = teclado.nextInt();
						if (opcao == 9) {
							System.out.println("Fechando conta...");
							break;
						} else if ((opcao < 0) || (opcao > 6 && opcao < 9) || (opcao > 9)) {
							System.out.println("Opcao Invalida!");
						} else if (opcao == 1) { // Depositar
							System.out.println("Valor do deposito:");
							double dinheiro = teclado.nextDouble();
							loginUsuario.depositar(dinheiro);
						} else if (opcao == 2) { // Sacar
							System.out.println("Valor do saque:");
							double dinheiro = teclado.nextDouble();
							loginUsuario.sacar(dinheiro);
						} else if (opcao == 3) { // Pagamento
							System.out.println("Valor do pagamento:");
							double dinheiro = teclado.nextDouble();
							loginUsuario.pagar(dinheiro);
						} else if (opcao == 4) { // Transferencia
							System.out.println("Valor a transferir:");
							double dinheiro = teclado.nextDouble();
							System.out.println("Id da conta: (Recebe a transferencia)");
							int codigo = teclado.nextInt();
							teclado.nextLine();
							System.out.println("CPF do titular: (Recebe a transferencia)");
							String cpf = teclado.nextLine();
							Conta conta = buscarConta(codigo, cpf, contas);
							loginUsuario.transferir(dinheiro, codigo, cpf, conta);
						} else if (opcao == 5) { // Exibir informacoes da conta
							System.out.println(loginUsuario);
						} else if (opcao == 6) { // Exibir Extrato
							loginUsuario.exibirExtrato();
						}
						
					}
				}
			}
		}
		
	}
	
	private static Conta buscarConta(int codigo, String cpf, ArrayList<Conta> lista) {
		Conta nConta = null;
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getId() == codigo) && (lista.get(i).getTitular().getCpf().equals(cpf))) {
				nConta = lista.get(i);
			}
		}
		return nConta;
	}

	public static int menuInicial(Scanner tc) {
		System.out.println(" Banco Itabaiana ");
		System.out.println("[ 1 ] Criar Conta");
		System.out.println("[ 2 ] Fazer Login");
		System.out.println("[ 9 ] Sair");
		System.out.print("Sua escolha: ");
		int opcao = tc.nextInt();
		return opcao;
	}
	
	public static Cliente criarCliente(Scanner tc) {
		tc.nextLine();
		System.out.println("Nome:");
		String nome = tc.nextLine();
		System.out.println("Endereco:");
		String endereco = tc.nextLine();
		System.out.println("Senha:");
		String senha = tc.nextLine();
		System.out.println("CPF:");
		String cpf = tc.nextLine();
		System.out.println("Celular:");
		String celular = tc.nextLine();
		System.out.println("Idade:");
		int idade = tc.nextInt();
		Cliente nCliente = new Cliente(nome, cpf, senha, celular, idade, endereco);
		return nCliente;
	}
	
	public static int tipoConta(Scanner tc) {
		System.out.println(" Tipo de Conta ");
		System.out.println("[ 1 ] Conta Corrente");
		System.out.println("[ 2 ] Conta Poupanca");
		System.out.print("Sua escolha: ");
		int opcao = tc.nextInt();
		return opcao;
	}
	
	public static Conta fazerLogin(Scanner tc, ArrayList<Conta> lista) {
		tc.nextLine();
		System.out.println("CPF:");
		String cpf = tc.nextLine();
		System.out.println("SENHA:");
		String senha = tc.nextLine();
		int cliente = verificarLogin(cpf, senha, lista);
		Conta usuLogado = null;
		if (cliente != -1) {
			System.out.println("Cliente Logado!");
			usuLogado = lista.get(cliente);
		} else {
			System.out.println("Cpf ou senha invalida!");
		}
		return usuLogado;
	}

	private static int verificarLogin(String cpf, String senha, ArrayList<Conta> lista) {
		int busca = -1;
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getTitular().getCpf().equals(cpf)) && (lista.get(i).getTitular().getSenha().equals(senha))) {
				busca = i;
				lista.get(i).getTitular().setEstaLogado(true);
			}
		}
		return busca;
	}
	
	public static void menuConta(Scanner tc, Conta cliente) {
		System.out.println(" Bem Vindo! " + cliente.getTitular().getNome());
		System.out.println("[ 1 ] Depositar");
		System.out.println("[ 2 ] Sacar");
		System.out.println("[ 3 ] Pagamento");
		System.out.println("[ 4 ] Transferencia");
		System.out.println("[ 5 ] Exibir informacoes da Conta");
		System.out.println("[ 6 ] Exibir Extrato");
		System.out.println("[ 9 ] Sair");
		System.out.print("Sua escolha: ");
	}
}
