package trabalhocontabancaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Cinthia
 *
 *         TODO Classe para criar um objeto do tipo arquivo de leitura
 */

public class LeArquivo {
	private Scanner entrada;

	public LeArquivo(String nome) throws FileNotFoundException {
		System.out.println("String recebida: " + nome);
		try {
			this.entrada = new Scanner(new File(nome));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("ARQUIVO NAO ENCONTRADO");
		}
	}

	/**
	 * Metodo para ler os dados contidos no arquivo
	 * 
	 * @param alunos => Vetor de alunos que sera preenchido durante a leitura do
	 *               arquivo
	 * @throws IllegalStateException => Excecao se houver erro ao ler o arquivo
	 */
	public CadConta leLinhas() throws NoSuchElementException, ArrayIndexOutOfBoundsException {
		CadConta cadastro = new CadConta();
		Conta conta;
		String linha;
		try {
			while (this.entrada.hasNext()) {
				// A fun��o hasNext() indica se ainda existe uma String
				// para ser lida.
				linha = this.entrada.nextLine();
				conta = separaDados(linha);
				cadastro.insere(conta);
				// A fun��o nextLine() devolve a pr�xima linha como
				// uma String.

				// cadastro.insere(separaDados(linha));
//				cadastro.insere(conta); // verificar se � realmente dessa forma
			}
			return cadastro;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Arquivo corrompido");
		}
	}

	/**
	 * Metodo para transformar uma linha do arquivo em um objeto do tipo Promissoria
	 * 
	 * @param linha => String contendo a linha do arquivo que sera transformada
	 * @return => a promissoria criada a partir do linha passada
	 * @throws NoSuchElementException => Excecao causada por elementos insuficientes
	 *                                na String, durante a transformacao
	 */
	private Conta separaDados(String linha) throws NoSuchElementException {
		String[] dados;
		String numeroConta;
		String nome, cpf;
		double valor_na_conta;
		double limite;

		Conta conta;
		ContaEspecial contaEspecial;

		CadConta cadConta = new CadConta();

		try {

			// FAZER If (dados) para verificar se � Conta Simples ou Especial, pois conta
			// simples tem 4 campos e especial tem 5 campos

			dados = linha.split(";");
			// O m�todo split quebra uma String em v�rias substrings a partir
			// do caracter definido como argumento,nesse caso ";", cria
			// um vetor de String e armazena cada substring em um posicao
			numeroConta = dados[0];
			nome = dados[1];
			cpf = dados[2];
			valor_na_conta = Double.parseDouble(dados[3]);

			if (numeroConta.charAt(1) == '2') {
				limite = Double.parseDouble(dados[4]);
				contaEspecial = new ContaEspecial(nome, cpf, Integer.parseInt(numeroConta), valor_na_conta, limite);

				return contaEspecial;
			} else {
				conta = new Conta(nome, cpf, Integer.parseInt(numeroConta), valor_na_conta);

				return conta;
			}
		} catch (NoSuchElementException erro) {
			throw new NoSuchElementException("ARQUIVO DIFERENTE DO REGISTRO");
		}
	}

	/**
	 * Metodo para fechar o arquivo de leitura
	 * 
	 * @throws IllegalStateException => Excecao causada se nao conseguir fechar o
	 *                               arquivo.
	 */
	public void fechaArquivo() throws IllegalStateException {
		try {
			this.entrada.close();
		} catch (IllegalStateException e) {
			throw new IllegalStateException("ERRO AO FECHAR O ARQUIVO");
		}
	}
}
