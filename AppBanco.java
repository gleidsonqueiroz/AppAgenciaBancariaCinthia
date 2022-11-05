package trabalhocontabancaria;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppBanco {
	static Scanner input = new Scanner(System.in);
	static GravaArquivo saida;

	public static void main(String[] args) throws FileNotFoundException {
		LeArquivo arquivoEntrada = new LeArquivo(
				"D:\\eclipse-workspace\\appbanco\\src\\trabalhocontabancaria\\cliente500alea.txt");

		CadConta cadConta = arquivoEntrada.leLinhas();

		arquivoEntrada.fechaArquivo();

		// cadConta.shellsort();
		cadConta.quicksort(null, 0, 0);

		cadConta.imprimeContas();

		System.out.println(cadConta.getTamanho());

		// ArrayList<Conta> contasBancarias;
		// contasBancarias = new ArrayList<Conta>();
		// operacoes(contasBancarias); // passar com o nome do arquivo ou fazer um for e
		// um vetor de string para le todos os nomes do arquivo

	
		//cadConta.quicksort(args, 0, 0);
		//cadConta.quicksort(null, 0, 0);
		
		System.out.println("----------------------------------------\n");
		cadConta.imprimeContas();
	}
	



	// public static void operacoes(ArrayList<Conta> contasBancarias){
	// // depois de passar o quick, vc vai fazer
	// try {
	// saida = new GravaArquivo("nome");
	// // for para o ArrayList
	// // saida.gravaArquivo(lista.get(i).toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// }

}
