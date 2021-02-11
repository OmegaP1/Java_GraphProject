package leitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class LeitorAbstrato implements Leitor{
	
	private String fileName;
	private int inic;
	
	public LeitorAbstrato(String fileName , int inic) {
		this.fileName = fileName;
		this.inic = inic;
	}
	
	public ArrayList<String> getList() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		String line;
		ArrayList<String> lista = new ArrayList<>();
		String[] t = new String[2];
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			t = line.split(",");
			lista.add(t[getIndex()]);
		}
		scan.close();
		return lista;
	}
	
	public int getNumOfX() throws FileNotFoundException {
		return (getList().size()-inic);
	}
	
	public int getMaxX() throws FileNotFoundException {
		LeitorX x = new LeitorX(fileName,0);
		ArrayList<String> listaX = x.getList();
		int max = 0 , result = 0;
		for(int i=inic; i<listaX.size(); i++) {
			result = Integer.parseInt(listaX.get(i));
			if(result > max)
				max = result;
		}
		return max;		
	}
	
	public int getMaxY() throws FileNotFoundException {
		ArrayList<String> listaY = getList();
		int max = 0 , result = 0;
		for(int i=inic; i<listaY.size(); i++) {
			result = Integer.parseInt(listaY.get(i));
			if(result > max)
				max = result;
		}
		return max;			
	}	
	
	
	public abstract int getIndex();

}
