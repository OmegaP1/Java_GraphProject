package acoes;

import java.io.FileNotFoundException;
import grafico.GraficoDispersao;
import pt.iscte.guitoo.Action;
import pt.iscte.guitoo.Flag;
import pt.iscte.guitoo.Option;
import pt.iscte.guitoo.Window;

public class AcaoDispersao extends Action {

	private String fileName;
	private String scale;
	private Flag c;
	private Window app;
	private boolean bool1,bool2;
	String ver = "Verde >= 50";
	String amarelo = "Amarelo < 50 e >=50";
	private Option<String> op;

	public AcaoDispersao(Flag c , Window app, Option<String> op) {
		this.app = app;
		this.c = c;
		this.op = op;
		addParameter("File Name:", () -> fileName, (a) -> !a.isEmpty());
		addParameter("Scale:", () -> scale, (a) -> !a.isEmpty());
	}

	protected void execute(String[] arg0) {
		try {	
			GraficoDispersao h;
			bool1=false;bool2=false;
			if( amarelo.equals(op.getSelected())) {
				bool1=true; bool2=false;
			}
			else if (ver.equals(op.getSelected())) {
				bool1=true; bool2=true;
			}
				
			if (c.isSelected()) {
				h = new GraficoDispersao(app);
				h.creat(arg0[0], Integer.parseInt(arg0[1]), 0, true,bool1,bool2);
				h.run();
			} else {
				h = new GraficoDispersao(app);
				h.creat(arg0[0], Integer.parseInt(arg0[1]), 0, false,bool1,bool2);
				h.run();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
