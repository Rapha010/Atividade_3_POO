package banco_itabaiana;

public class ContaCorrente extends Conta {
	
	private double limiteMaxSaque;
	private double chequeEspecial;
	private double taxaCheque;
	
	public ContaCorrente(int id, Cliente titular) {
		super(id, titular);
		this.limiteMaxSaque = 1000;
		this.chequeEspecial = 200;
		this.taxaCheque = 0.5;
	}

	public double getLimiteMaxSaque() {
		return limiteMaxSaque;
	}

	public void setLimiteMaxSaque(double limiteMaxSaque) {
		this.limiteMaxSaque = limiteMaxSaque;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public double getTaxaCheque() {
		return taxaCheque;
	}

	public void setTaxaCheque(double taxaCheque) {
		this.taxaCheque = taxaCheque;
	}

	@Override
	public void sacar(double valor) {
		if (this.isStatus() == true) {
			if (this.getSaldo() >= valor && valor < limiteMaxSaque) {
				double novoSaldo = getSaldo() - valor;
				setSaldo(novoSaldo);
				System.out.println("Saque concluido!");
			} else {
				System.out.println("Saque invalido, Saldo insuficiente!");
			}
		} else {
			System.out.println("Conta Bloqueada!");
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [" +
				"\n - IdConta = " + getId() +
				"\n - Titular = " + getTitular() +
				"\n - Saldo = " + getSaldo() +
				"\n - StatusConta = " + isStatus() +
				"\n - LimiteMaxSaque = " + limiteMaxSaque +
				"\n - ChequeEspecial = " + chequeEspecial +
				"\n - TaxaCheque = " + taxaCheque + 
				"\n ]";
	}

}
