package leitor;

public class LeitorX extends LeitorAbstrato {

	public LeitorX(String fileName, int inic) {
		super(fileName, inic);
	}

	@Override
	public int getIndex() {
		return 0;
	}
}
