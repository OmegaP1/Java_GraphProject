package acoes;

import java.io.FileNotFoundException;

import grafico.GraficoHistograma;
import pt.iscte.guitoo.Action;
import pt.iscte.guitoo.Flag;
import pt.iscte.guitoo.Option;
import pt.iscte.guitoo.Window;

public class AcaoHistograma extends Action {

	private String fileName;
	private String scale;
	private Flag n;
	private Window app; 
	String ver = "Verde >= 50";
	private Option<String> op;
	private boolean bool;
	
	public AcaoHistograma(Flag n , Window app, Option<String> op) {
		this.app = app;
		this.n = n;
		this.op=op;
		addParameter("File Name:", () -> fileName, (a) -> !a.isEmpty());
		addParameter("Scale:", () -> scale, (a) -> !a.isEmpty());
	}

	protected void execute(String[] arg0) {
		try {
			GraficoHistograma h;
			if(ver.equals(op.getSelected())) {
				bool = true;
			}else
				bool = false;
			
			if(n.isSelected()) {
				h = new GraficoHistograma(app);
				h.creat(arg0[0],Integer.parseInt(arg0[1]),11,false,bool);
				h.run();
				}
			else {
				h = new GraficoHistograma(app);
				h.creat(arg0[0],Integer.parseInt(arg0[1]),0,false,bool);
				h.run();
			}
			 
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();	
		}
	}
}
