package banco_itabaiana;

public class ContaPoupanca  extends Conta{
	
	private double taxaJuros;
	
	public ContaPoupanca(int id, Cliente titular) {
		super(id, titular);
		this.taxaJuros = 0.2;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [" +
				"\n - IdConta = " + getId() +
				"\n - Titular = " + getTitular() +
				"\n - Saldo = " + getSaldo() +
				"\n - StatusConta = " + isStatus() +
				"\n - TaxaJuros = " + taxaJuros +
				"\n ]";
	}
	
}
