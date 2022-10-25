package trabalho_Conta_Bancaria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import trabalho_Conta_Bancaria.Conta;
import trabalho_Conta_Bancaria.GravaArquivo;

public class AppBanco {
    static Scanner input = new Scanner(System.in);
    static GravaArquivo saida;

	public static void main(String[] args) {
		ArrayList<Conta> contasBancarias;
        contasBancarias = new ArrayList<Conta>();
        operacoes(contasBancarias);	// passar com o nome do arquivo ou fazer um for e um vetor de string para le todos os nomes do arquivo
        
	}
	
	public static void operacoes(ArrayList<Conta> contasBancarias){
		// depois de passar o quick, vc vai fazer
        try {
			saida = new GravaArquivo("nome");
			// for para o ArrayList
			   // saida.gravaArquivo(lista.get(i).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
