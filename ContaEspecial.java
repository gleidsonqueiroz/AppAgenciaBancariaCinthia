package trabalhocontabancaria;

public class ContaEspecial extends Conta { //implements Transacao{ nao precisa pois atraves da Classe Conta ira herda.

	public double limite;
		
	public ContaEspecial(String nome, String cpf, int numero, double valor_na_conta, double limite) {
		super(nome, cpf, numero, valor_na_conta);
		this.limite = limite;
		// TODO Auto-generated constructor stub
	}

	
	// Falta public double saldo(); para a ContaEspecial

	//	verificar se ficar assim
	@Override
	public double saldo() {
		// TODO Auto-generated method stub
		return super.saldo();
	}


}
