package banco_itabaiana;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String senha;
	private String celular;
	private int idade;
	private String endereco;
	private boolean estaLogado;

	public Cliente(String nome, String cpf, String senha, String celular, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.celular = celular;
		this.idade = idade;
		this.endereco = endereco;
		this.estaLogado = false;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isEstaLogado() {
		return estaLogado;
	}

	public void setEstaLogado(boolean estaLogado) {
		this.estaLogado = estaLogado;
	}

	@Override
	public String toString() {
		return "Cliente [" +
				"\n - Nome = " + nome +
				"\n - CPF = " + cpf +
				"\n - Senha = " + senha +
				"\n - Celular = " + celular +
				"\n - Idade = " + idade +
				"\n - Endereco = " + endereco + 
				"\n ]";
	}
	
}
