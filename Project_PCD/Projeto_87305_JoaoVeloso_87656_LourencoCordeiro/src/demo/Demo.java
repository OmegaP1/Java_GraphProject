package demo;
import pt.iscte.guitoo.*;

public class Demo {
	private Window app;
	private StaticText text;

	public Demo() {
		app = new Window("Demo", 900, 300, true);
		text = new StaticText("hello", 100, 20);
		app.addFigure(text);
		app.addLabel(() -> app.getCanvasWidth() + " x " + app.getCanvasHeight());
		app.addAction("set text", new SetText());
		app.addFigure(new Square(50));
		ArrayFigure array = new ArrayFigure(50, 50);
		app.addFigure(array);
		
		Flag centerFlag = app.addFlag("center", false);
		Option<StandardColor> colorOption = app.addOption("color", StandardColor.WHITE, StandardColor.RED,
				StandardColor.GREEN);
		
		app.addAction("create square", new Action() {
			protected void execute(String[] args) {
				Square square = new Square(50);
				if (centerFlag.isSelected())
					square.move(app.getCanvasWidth() / 2, app.getCanvasHeight() / 2);
				StandardColor color = colorOption.getSelected();
				square.setColor(color);
				app.addFigure(square);
			}
		});
	}

	public void run() {
		app.open();
	}

	class SetText extends Action {
		public SetText() {
			addParameter("text", () -> text.getText(), (a) -> !a.isEmpty());
		}

		public void execute(String[] args) {
			text.setText(args[0]);
		}
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();
	}
}