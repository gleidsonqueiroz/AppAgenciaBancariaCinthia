package trabalhocontabancaria;

import java.util.ArrayList;

public class CadConta implements Vetor {

	ArrayList<Conta> contas;

	public CadConta() {
		contas = new ArrayList<Conta>();
	}

	@Override
	public int getTamanho() {
		return contas.size();
	}

	@Override
	public Conta getConta(int pos) {
		return contas.get(pos);
	}

	@Override
	public void insere(Conta conta) {
		contas.add(conta);
	}

	@Override
	//public void quicksort(String[] vetor , int esquerda, int direita) {
	public void quicksort(ArrayList<String[]> vetor, int esquerda, int direita) {
		
//		if (esquerda < direita) {
//			//String pivo = divisaoVetor[Vetor, esquerda, direita];
//		}
//		
		
		
		if (esquerda < direita){
            int p = particao(vetor, esquerda, direita);
			
            this.quicksort(vetor, esquerda, p);
            this.quicksort(vetor, p + 1, direita);
        }
    }
	
	static int particao(ArrayList<String[]> vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita) / 2;
        String pivot = vetor.get(meio)[1];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true){
            do{
                i++;
            }while(vetor.get(i)[1].compareToIgnoreCase(pivot) < 0);
            do{
                j--;
            }while(vetor.get(j)[1].compareToIgnoreCase(pivot) > 0);
            if (i >= j){
                return j;
            }
            String[] aux = vetor.get(i);
            vetor.set(i, vetor.get(j));
            vetor.set(j, aux);
        }
	}

	
	
	
	@Override
	public void shellsort(ArrayList<String[]> vetor) {
		int h = 1;
		int n = vetor.size();
		while(h < n) {
			h = h * 3 + 1;
		}
		h = (int) Math.floor(h / 3);
		
		String[] elemento;
		int j;
		
		while(h > 0) {
			
			for(int i = h; i < n; i++) {
				elemento = vetor.get(i);
				j = i;
				
				while(j >= h && vetor.get(j - h)[1].compareToIgnoreCase(elemento[1]) > 0) {
					vetor.set(j, vetor.get(j - h));
					j = j - h;
				}
				vetor.set(j, elemento);
			}
			h = h / 2;
		}

	}

	
	// para testar somente, depois remover!!
	public void imprimeContas() {
		for (Conta conta : contas) {
			System.out.print(conta.getNome() + " ");
			System.out.println(conta.getCpf());
		}
	}
}
