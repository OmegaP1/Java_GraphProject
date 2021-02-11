package dados;

import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;

public class Tuplo {

	private final String x, y;
	private Color C = StandardColor.WHITE;

	public Tuplo(String x, String y) {
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public Color getC() {
		return C;
	}
	
	public void SetC(Color c) {
		this.C = c;
	}

}
