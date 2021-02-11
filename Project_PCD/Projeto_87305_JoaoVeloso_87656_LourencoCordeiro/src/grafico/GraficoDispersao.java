package grafico;

import java.io.FileNotFoundException;

import dados.ConjuntoDados;
import figuras.Circle;
import figuras.Rectangule;
import leitor.LeitorAbstrato;
import leitor.LeitorX;
import leitor.LeitorY;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;
import pt.iscte.guitoo.Window;

public class GraficoDispersao extends GraficoAbstrato implements FiltrosCores {
	public static int numTimesX;

	public GraficoDispersao() throws FileNotFoundException {
		super();
	}

	public GraficoDispersao(Window app) {
		super(app);
	}

	public void creat(String fileName, int scale, int inic, boolean b,boolean bool1, boolean bool2) throws FileNotFoundException {
		this.scale = scale;
		this.inic = inic;
		this.fileName = fileName;
		this.cd = new ConjuntoDados(fileName, inic);
		app.clear();
		setColor(bool1, bool2);
		addXEixo();
		addYEixo();
		addElements(b);
		addXLabel();
		addYLabel();
	}

	@Override
	public void addElements(boolean c) throws FileNotFoundException {
		Circle cir;
		LeitorY y = new LeitorY(fileName, 0);
		for (int i = 0; i < y.getNumOfX(); i++) {
			cir = new Circle(200 + scale * Integer.parseInt(cd.getX(i)) * 2,
					100 + scale * (2 * y.getMaxY() - 2 * Integer.parseInt(cd.getY(i))));
			cir.setColor(cd.getTuplo(i).getC());
			if (c && Integer.parseInt(cd.getY(i)) >= 50)
				app.addFigure(cir);
			if (!c)
				app.addFigure(cir);
		}
	}

	public void RoundedNumX() throws FileNotFoundException {
		LeitorAbstrato la = new LeitorX(fileName, 0);
		int round = la.getMaxX();
		while (round % 10 != 0) {
			round++;
		}
		numTimesX = (round / 10) + 1;
	}

	@Override
	public void RoundedNum() throws FileNotFoundException {
		LeitorAbstrato la = new LeitorY(fileName, 0);
		int round = la.getMaxY();
		while (round % 10 != 0) {
			round++;
		}
		numTimesY = (round / 10) + 1;
	}

	@Override
	public void addXLabel() throws FileNotFoundException {
		RoundedNum();
		RoundedNumX();
		LeitorY y = new LeitorY(fileName, 0);
		for (int i = 0, a = 0, b = 0; i < numTimesX; a += 20, i++, b += 10) {
			text = new StaticText(b, 200 + a * scale, 120 + (2 * y.getMaxY() * scale));
			app.addFigure(text);
		}
	}

	@Override
	public void addYLabel() throws FileNotFoundException {
		LeitorAbstrato la = new LeitorY(fileName, 0);
		RoundedNum();
		for (int i = 0, a = 20, b = 0; i < numTimesY; b += 10, a += 20 * scale, i++) {
			text = new StaticText(b, 180, ((2 * la.getMaxY()) * scale) + 120 - a);
			app.addFigure(text);
		}
	}

	@Override
	public void addXEixo() throws FileNotFoundException {
		RoundedNum();
		RoundedNumX();
		LeitorAbstrato leitorY = new LeitorY(fileName, 0);
		Rectangule eixoX = new Rectangule((20 * numTimesX) * scale, 1);
		eixoX.setLocation(new Point(200, 100 + (2 * leitorY.getMaxY()) * scale));
		app.addFigure(eixoX);
	}

	@Override
	public void addYEixo() throws FileNotFoundException {
		LeitorAbstrato leitorY = new LeitorY(fileName, 0);
		Rectangule eixoY = new Rectangule(1, scale * 2 * leitorY.getMaxY());
		eixoY.setLocation(new Point(200, 100));
		app.addFigure(eixoY);
	}

	public static void main(String[] args) throws FileNotFoundException {
		GraficoDispersao d = new GraficoDispersao();
		d.run();
	}

	@Override
	public void setColor(boolean a, boolean b) {
		for (int i = 0; i != cd.getSize(); i++) {
			if (a == true && b == true) {
				if (Integer.parseInt(cd.getX(i)) >= 50) {
					cd.getTuplo(i).SetC(StandardColor.GREEN);
				} else {
					cd.getTuplo(i).SetC(StandardColor.RED);
				}
			}
			if (a == true && b == false) {
				if (Integer.parseInt(cd.getY(i)) >= 50 && Integer.parseInt(cd.getX(i)) < 50) {
					cd.getTuplo(i).SetC(StandardColor.YELLOW);
				}

			}
		}
	}
}
