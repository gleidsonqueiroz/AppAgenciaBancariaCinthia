package trabalho_Conta_Bancaria;

public class ContaEspecial extends Conta { //implements Transacao{ nao precisa pois atraves da Classe Conta ira herda.

	public double limte;
		
	public ContaEspecial(String nome, String cpf, int numero, double valor_na_conta) {
		super(nome, cpf, numero, valor_na_conta);
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
