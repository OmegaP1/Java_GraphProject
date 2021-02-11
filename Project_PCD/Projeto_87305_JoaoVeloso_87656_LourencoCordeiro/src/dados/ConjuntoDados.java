package dados;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import leitor.LeitorAbstrato;
import leitor.LeitorX;
import leitor.LeitorY;

public class ConjuntoDados {
	
	private Tuplo[] dados;
	private int inic;
	
	public ConjuntoDados(String fileName , int inic) throws FileNotFoundException {
		this.inic = inic;
		LeitorAbstrato x = new LeitorX(fileName , inic);
		LeitorAbstrato y = new LeitorY(fileName , inic);
		ArrayList<String> listaX = x.getList();
		ArrayList<String> listaY = y.getList();
		Tuplo[] dados = new Tuplo[x.getNumOfX()];
		for(int i=0 , n=this.inic; i<dados.length; i++,n++) {
			dados[i] = new Tuplo(listaX.get(n),listaY.get(n));
		}
		this.dados = dados;		
	}
	
	public Tuplo getTuplo(int index) {
		return dados[index];
	}
	
	public String getX(int index) {
		return dados[index].getX();
	}
	
	public String getY(int index) {
		return dados[index].getY();
	}
	
	public int getSize() {
		return dados.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(dados);
	}
}
