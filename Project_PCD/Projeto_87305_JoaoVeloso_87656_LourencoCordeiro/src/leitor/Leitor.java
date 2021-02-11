package leitor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Leitor {
	
	public ArrayList<String> getList() throws FileNotFoundException;
	public int getNumOfX() throws FileNotFoundException;
	public int getMaxY() throws FileNotFoundException;
	public abstract int getIndex();

}
