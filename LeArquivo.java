package trabalho_Conta_Bancaria;

import trabalho_Conta_Bancaria.CadConta;

import java.io.*;
import java.util.*;

import trabalho_Conta_Bancaria.Vetor;

/**
 * @author Cinthia
 *
 * TODO Classe para criar um objeto do tipo arquivo de leitura
 */

public class LeArquivo {
	private Scanner entrada;
	// objeto do tipo Scanner para realizar a leitura dos dados
	// do arquivo.
	/**
	 * Construtor
	 * @param nome => Nome do arquivo que sera aberto para leitura
	 * @throws FileNotFoundException => Excecao se nao encontrar o arquivo
	 */
	public LeArquivo(String nome) throws FileNotFoundException{
		try{
			this.entrada = new Scanner (new File (nome));
			//Instanciamento do objeto do tipo Scanner, tendo como argumento 

			// File que será o arquivo que será lido
		}
		catch (FileNotFoundException e){
			throw new FileNotFoundException ("ARQUIVO NAO ENCONTRADO");
		}
	}
	/**
	 * Metodo para ler os dados contidos no arquivo
	 * @param alunos => Vetor de alunos que sera preenchido durante a
	 * leitura do arquivo
	 * @throws IllegalStateException => Excecao se houver erro ao ler o
	 * arquivo
	 */
	public CadConta leArquivo(int tam)throws NoSuchElementException,ArrayIndexOutOfBoundsException{
		CadConta cadastro = new CadConta(tam);
		String linha;
		try{
			while (this.entrada.hasNext()){
				// A função hasNext() indica se ainda existe uma String
				// para ser lida.
				linha = this.entrada.nextLine();
				// A função nextLine() devolve a próxima linha como
				// uma String.
				
				//cadastro.insere(separaDados(linha));
				cadastro.insere();  // verificar se é realmente dessa forma
			}
			return cadastro;
		}
		catch (ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Arquivo corrompido");
		}
	}
	/**
	 * Metodo para transformar uma linha do arquivo em um objeto
	 * do tipo Promissoria
	 * @param linha => String contendo a linha do arquivo que sera
	transformada
	 * @return => a promissoria criada a partir do linha passada
	 * @throws NoSuchElementException => Excecao causada por elementos
	 * insuficientes na String, durante a transformacao
	 */
	private Vetor separaDados(String linha)throws NoSuchElementException{
		String[] dados;
		String nome, cpf;
		int numero;
		double valor_na_conta;
		
		try{
			
			//FAZER If (dados) para verificar se é Conta Simples ou Especial, pois conta simples tem 4 campos e especial tem 5 campos
			
			dados = linha.split(";");
			// O método split quebra uma String em várias substrings a partir
			// do caracter definido como argumento,nesse caso ";", cria
			// um vetor de String e armazena cada substring em um posicao
			String aux = dados[0];
			nome = dados[1];
			cpf = dados[2];
			numero = Integer.parseInt(dados[3]); // mudar com parse int
			valor_na_conta = Double.parseDouble(dados[4]);
			
			return (new Vetor(nome, cpf, numero, valor_na_conta));
			 
		}
		catch (NoSuchElementException erro){
			throw new NoSuchElementException ("ARQUIVO DIFERENTE DO REGISTRO");
		}
	}

	/**
	 * Metodo para fechar o arquivo de leitura
	 * @throws IllegalStateException => Excecao causada se nao conseguir
	 * fechar o arquivo.
	 */
	public void fechaArquivo ()throws IllegalStateException{
		try{
			this.entrada.close();
		}
		catch (IllegalStateException e){
			throw new IllegalStateException ("ERRO AO FECHAR O ARQUIVO");
		}
	}
}
