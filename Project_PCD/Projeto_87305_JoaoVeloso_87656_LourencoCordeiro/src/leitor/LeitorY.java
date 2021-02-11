package leitor;

public class LeitorY extends LeitorAbstrato {

	public LeitorY(String fileName, int inic) {
		super(fileName, inic);
	}

	public int getIndex() {
		return 1;
	}
}
