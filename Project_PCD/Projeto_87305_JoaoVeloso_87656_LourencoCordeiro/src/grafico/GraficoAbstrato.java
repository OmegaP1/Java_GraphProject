package grafico;

import java.io.FileNotFoundException;
import java.util.function.Supplier;

import acoes.AcaoDispersao;
import acoes.AcaoHistograma;
import acoes.AcaoLinhas;
import dados.ConjuntoDados;
import figuras.Rectangule;
import leitor.LeitorAbstrato;
import leitor.LeitorY;
import pt.iscte.guitoo.Flag;
import pt.iscte.guitoo.Option;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;
import pt.iscte.guitoo.Window;

public abstract class GraficoAbstrato {
	
	protected int scale=1;
	protected Window app;
	protected String fileName;
	protected ConjuntoDados cd;
	protected static int numTimesY;
	protected StaticText text;
	protected int inic = 0;
	public Flag n , c;
	public Option<String> opt;
	public boolean op = false;	

	public GraficoAbstrato() throws FileNotFoundException {
		this.app = new Window("JGrafas", 1600, 800, false);
		StaticText text = new StaticText("Projeto POO", 800, 400);
		StaticText jv = new StaticText("Joao Veloso - 87305", 1400, 700);
		StaticText lc = new StaticText("Lourenco Cordeiro - 87656", 1400, 730);
		jv.setFontSize(20);
		lc.setFontSize(20);
		text.setFontSize(200);
		app.addFigure(text);
		app.addFigure(jv);
		app.addFigure(lc);
		CreatOpt();
		n = app.addFlag("Negativas", false);
		c = app.addFlag("< 50", false);
		app.addAction("HISTOGRAMA", new AcaoHistograma(n , app, opt));
		app.addAction("DISPERSAO", new AcaoDispersao(c , app,opt));
		app.addAction("LINHAS", new AcaoLinhas(app,opt));
		
		
			
	}
	public void CreatOpt() {
		String normal = "Sem cor"; 
		String ver = "Verde >= 50";
		String amarelo = "Amarelo < 50 e >=50";
		opt = app.addOption("cores", normal,ver,amarelo);
	}
	
	public GraficoAbstrato(Window app) {
		this.app = app;
	

	}
	
	public void addOptions() {
	}
	
	public void Negativas() {
	if(n.isSelected())
		this.inic = 11;
	else
		this.inic = 0;	
	}

	public void addXEixo() throws FileNotFoundException {
		RoundedNum();
		Rectangule eixoX = new Rectangule((10 + 2 * (cd.getSize()) * 10)*scale, 1);
		eixoX.setLocation(new Point(200, 100 + (scale * 2 * (numTimesY-1)*20)));
		app.addFigure(eixoX);
	}

	public void addYEixo() throws FileNotFoundException {
		RoundedNum();
		Rectangule eixoY = new Rectangule(1, (scale * 2 * (numTimesY-1)*20));
		eixoY.setLocation(new Point(200, 100));
		app.addFigure(eixoY);
	}

	public abstract void addElements(boolean c) throws FileNotFoundException;

	public void addXLabel() throws FileNotFoundException {
		for (int i = 0, a = 10; i < cd.getSize(); a += 20, i++) {
			text = new StaticText(cd.getX(i),200 + a*scale, 120+(scale * 2 * (numTimesY-1)*20));
			app.addFigure(text);
		}
	}
	
	public void addYLabel() throws FileNotFoundException {
		RoundedNum();
		int dist = ((scale * 2 * (numTimesY-1)*20)/numTimesY)+6*scale;
		for (int i = 0, a = 20, b = 0; i <numTimesY; b += 20, a += dist, i++) {
			text = new StaticText(b, 180, ((scale * 2 * (numTimesY-1)*20)) + 120 - a);
			app.addFigure(text);
		}
	}

	public void RoundedNum() throws FileNotFoundException {
		LeitorAbstrato la = new LeitorY(fileName, inic);
		int round = la.getMaxY();
		while (round % 20 != 0) {
			round++;
		}
		numTimesY = (round / 20) + 1;
	}

	public void run() {
		app.open();
	}
}