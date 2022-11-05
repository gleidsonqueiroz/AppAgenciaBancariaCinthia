package trabalhocontabancaria;

import java.util.ArrayList;

public interface Vetor {
	
	public int getTamanho(); 	// inteiro
	public Conta getConta(int pos);		// double
	public void insere(Conta conta);		// void
	//public void quicksort(String[] Vetor , int esquerda, int direita);	// antes estava public void quicksort() 
	
	public void quicksort(ArrayList<String[]> vetor, int esquerda, int direita);
	public void shellsort(ArrayList<String[]> vetor);	//
	 
}
