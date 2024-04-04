package banco_itabaiana;

public interface AcoesConta {
	public void depositar(double valor);
	public void sacar(double valor);
	public void pagar(double valor);
	public void transferir(double valor, int id, String cpf, Conta destino);
	
}
