package banco_itabaiana;

import java.util.Stack;

public abstract class Conta implements AcoesConta {
	
	private int id;
	private Cliente titular;
	private double saldo;
	private boolean status;
	private Stack<Conta> registro = new Stack<>();
	
	public Conta(int id, Cliente titular) {
		this.id = id;
		this.titular = titular;
		this.saldo = 0;
		this.status = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public void depositar(double valor) {
		if(isStatus() == true) {
			double novoSaldo = getSaldo() + valor;
			setSaldo(novoSaldo); 
			System.out.println("Deposito concluido!");
		} else {
			System.out.println("Conta Bloqueada!");
		}
		
	}

	@Override
	public void sacar(double valor) {
		if (isStatus() == true) {
			if (this.getSaldo() >= valor) {
				double novoSaldo = getSaldo() - valor;
				setSaldo(novoSaldo);
				System.out.println("Saque concluido!");
			} else {
				System.out.println("Saque invalido, Saldo insuficiente!");
				bloquearConta();
			}
		} else {
			System.out.println("Conta Bloqueada!");
		}
	}

	@Override
	public void pagar(double valor) {
		if (isStatus() == true) {
			if (this.getSaldo() >= valor) {
				double novoSaldo = getSaldo() - valor;
				setSaldo(novoSaldo);
				System.out.println("Pagamento concluido!");
			} else {
				System.out.println("Pagamento nao realizado, Saldo insuficiente!");
			}
		} else {
			System.out.println("Conta Bloqueada!");
		}
	}

	@Override
	public void transferir(double valor, int id, String cpf, Conta destino) {
		if (isStatus() == true) {
			if (this.getSaldo() >= valor) {
				if (destino != null) {
					double novoSaldo = getSaldo() - valor;
					setSaldo(novoSaldo);
					novoSaldo = destino.getSaldo() + valor;
					destino.setSaldo(novoSaldo);
					System.out.println("Transferencia concluida!");
				} else {
					System.out.println("A conta de destino nao existe!");
				}
			} else {
				System.out.println("Transferencia nao realizada, Saldo insuficiente!");
			}
		} else {
			System.out.println("Conta Bloqueada!");
		}
	}
	
	public void exibirExtrato() {
		for (Conta conta : registro) {
			System.out.println(conta);
		}
	}
	
	public void bloquearConta() {
		 setStatus(false);;
	}
	
	public void desbloquearConta() {
		setStatus(true);
	}
	
}
