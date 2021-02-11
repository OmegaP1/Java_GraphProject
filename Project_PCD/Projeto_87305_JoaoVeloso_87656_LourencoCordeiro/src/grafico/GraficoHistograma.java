package grafico;

import java.io.FileNotFoundException;

import acoes.AcaoHistograma;
import dados.ConjuntoDados;
import figuras.Rectangule;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.Window;

public class GraficoHistograma extends GraficoAbstrato implements FiltrosCores{

	public GraficoHistograma() throws FileNotFoundException {
		super();
	}
	
	public GraficoHistograma(Window app) {
		super(app);
	}

	@Override
	public void addElements(boolean c) throws FileNotFoundException {
		Rectangule barra;
		for (int a = 0, i = 200+5*scale; a<cd.getSize(); a++, i+=20*scale) {
			barra = new Rectangule(10*scale, scale * 2 * Integer.parseInt(cd.getY(a)));
			barra.changePosition(i,(( 2 * (numTimesY-1)*20 - 2 * Integer.parseInt(cd.getY(a)))*scale)+100);
			barra.setColor(cd.getTuplo(a).getC());
			app.addFigure(barra);
		}
	}	

	public static void main(String[] args) throws FileNotFoundException {
		GraficoHistograma h = new GraficoHistograma();
		h.run();
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
	
	public void creat(String fileName , int scale , int inic , boolean b,boolean cor) throws FileNotFoundException {
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
	}

}