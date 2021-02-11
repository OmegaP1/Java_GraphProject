package grafico;

import java.io.FileNotFoundException;

import acoes.AcaoDispersao;
import acoes.AcaoHistograma;
import acoes.AcaoLinhas;
import dados.ConjuntoDados;
import figuras.Circle;
import figuras.Line;
import figuras.Rectangule;
import leitor.LeitorY;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;
import pt.iscte.guitoo.Window;

public class GraficoLinhas extends GraficoAbstrato implements FiltrosCores{

	public GraficoLinhas() throws FileNotFoundException {
		super();
	}
	
	public GraficoLinhas(Window app) {
		super(app);
	}
	
	public void creat(String fileName , int scale , int inic , boolean b, boolean cor) throws FileNotFoundException {
		this.scale = scale;
		this.inic = inic;
		this.fileName = fileName;
		this.cd = new ConjuntoDados(fileName, inic);
		app.clear();
		setColor(cor,false);
		addXEixo();
		addYEixo();
		addElements(b);
		addXLabel();
		addYLabel();
		addLines();
	}
	
	@Override 
	public void addXEixo() throws FileNotFoundException {
		RoundedNum();
		Rectangule eixoX = new Rectangule((10 + 2 * (cd.getSize()) * 20)*scale, 1);
		eixoX.setLocation(new Point(200, 100 + (scale * 2 * (numTimesY-1)*20)));
		app.addFigure(eixoX);
	}
	
	@Override
	public void addXLabel() throws FileNotFoundException {
		for (int i = 0, a = 10; i < cd.getSize(); a += 50, i++) {
			text = new StaticText(cd.getX(i),200 + a*scale, 120+(scale * 2 * (numTimesY-1)*20));
			app.addFigure(text);
		}
	}

	@Override
	public void addElements(boolean a) throws FileNotFoundException {
		Circle c;
		for(int i=0,w=220; i<cd.getSize();i++,w+=50*scale) {
			c = new Circle(w,100+scale*(2 * (numTimesY-1)*20-2*Integer.parseInt(cd.getY(i))));
			c.setColor(cd.getTuplo(i).getC());
			app.addFigure(c);
		}		
	}
	
	public void addLines() {
		Line l;
		for(int i=1 , w=220; i< cd.getSize(); i++ , w+=50*scale) {
			Point now = new Point(w,100+scale*(2 * (numTimesY-1)*20-2*Integer.parseInt(cd.getY(i-1))));
			Point next = new Point(w+50*scale,100+scale*(2 * (numTimesY-1)*20-2*Integer.parseInt(cd.getY(i))));
			l = new Line(now,next);
			app.addFigure(l);
		}
	}
	
	@Override
	public void setColor(boolean a, boolean b) {
		if (a ) {
			for(int i = 0; i!=cd.getSize(); i++) {
				if(Integer.parseInt(cd.getY(i))>=50) {
					cd.getTuplo(i).SetC(StandardColor.GREEN);
										
				}
				else {
					cd.getTuplo(i).SetC(StandardColor.RED);
				}					
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		GraficoLinhas l = new GraficoLinhas();
		l.run();
	}

}
