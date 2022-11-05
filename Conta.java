package trabalhocontabancaria;

public class Conta implements Transacao {

	private String nome;
	private String cpf;
	private int numero;
	private double valor_na_conta;
	
	//Instanciando o Construtor 
	public Conta(String nome, String cpf, int numero, double valor_na_conta) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.valor_na_conta = valor_na_conta; // Mudar para 0 ou instancia com Null ?
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getValor_na_conta() {
		return valor_na_conta;
	}
	
//	public void setValor_na_conta(double valor_na_conta) {
//		this.valor_na_conta = valor_na_conta;
//	}
	
	// Metodos adicionar pela Classe Interface Transacao
	@Override
	public void deposito(double valor) {
		this.valor_na_conta += valor;
	}
	
	@Override
	public boolean saque(double valor) { // sacar
		if(valor < this.valor_na_conta) {
			this.valor_na_conta -= valor;
				return true;
		}else { 
		return false;
		}
	}
	
	@Override
	public double saldo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean transferencia(double valor, Conta conta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// para teste
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", cpf=" + cpf + ", numero=" + numero + ", valor_na_conta=" + valor_na_conta
				+ "]";
	}
		
}
