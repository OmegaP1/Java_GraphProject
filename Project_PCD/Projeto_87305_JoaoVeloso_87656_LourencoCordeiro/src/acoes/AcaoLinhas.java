package acoes;

import java.io.FileNotFoundException;
import grafico.GraficoLinhas;
import pt.iscte.guitoo.Action;
import pt.iscte.guitoo.Option;
import pt.iscte.guitoo.Window;

public class AcaoLinhas extends Action{

	private String fileName;
	private String scale;
	private Window app;
	private boolean bool;
	String ver = "Verde >= 50";
	private Option<String> op;
	
	
	public AcaoLinhas(Window app, Option<String> op) {
		this.app = app;
		this.op=op;
		addParameter("File Name:", () -> fileName, (a) -> !a.isEmpty());
		addParameter("Scale:", () -> scale, (a) -> !a.isEmpty());
	}
	
	protected void execute(String[] arg0) {
		GraficoLinhas h;
		try {
			if(ver.equals(op. getSelected())) {
				bool=true;
			}else
				bool = false;
			h = new GraficoLinhas(app);
			h.creat(arg0[0],Integer.parseInt(arg0[1]),0,false,bool);
			h.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
