package trabalhocontabancaria;
import java.io.*;

public class GravaArquivo {

	//
	/**
	 * @author Cinthia
	 *
	 * TODO Esta classe cria um objeto que e um arquivo para gravacao
	 */
	private FileWriter writer;
	// objeto que representara o �gravador� de caracteres.
	private PrintWriter saida;
	// objeto que possibilita escrever Strings no arquivo
	// utilizando os m�todos print() e println().
	/**
	 * Construtor da classe
	 * @param nome => nome do arquivo que sera aberto para gravacao
	 * @throws IOException => Excecao se houver algum problema se osadsa
	 * arquivo nao puder ser aberto para gravacao
	 */
	
	public GravaArquivo (String nome) throws IOException{
		
		try{
			// false significa que se o arquivo ja existir, ele sera
			// sobrescrito caso queira apenas acrescentar dados ao final
			// do arquivo, deve usar true. Se o arquivo nao existir, cria um.
			writer = new FileWriter(new File(nome), true);
			// esse objeto significa que significando que 0 arquivo poder�
			// sofrer inclus�o de dados. O segundo argumento (opcional) indica
			// (true) que os dados ser�o enviados para o arquivo a toda
			// chamada do m�todo println(), caso contr�rio, os dados s� s�o
			// enviados quando voce enviar uma quebra de linha, fechar o
			// arquivo ou mandar ele atualizar as mudan�as (modo autoflush).
			saida = new PrintWriter (writer);
		}
		catch (IOException e){
			throw new IOException ("ARQUIVO NAO PODE SER ABERTO PARA"+
					"GRAVACAO");
		}
	}
	/**
	 * Este metodo grava uma String qualquer em um arquivo tipo texto
	 * @param str => String a ser gravada no arquivo
	 */
	public void gravaArquivo (String str) {
		this.saida.print(str);
	}
	/**
	 * Metodo para fechar o arquivo de gravacao
	 * @throws IOException => Excecao, se ocorrer erro ao fechar o
	 * arquivo.
	 */
	public void fechaArquivo ()throws IOException{
		try{
			this.saida.close();
			this.writer.close();
		}
		catch (IOException e){

			throw new IOException ("ERRO AO FECHAR O ARQUIVO");
		}
	}
}





//

