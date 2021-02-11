package demo;
import java.util.*;
import pt.iscte.guitoo.*;

public class ArrayFigure implements CompositeFigure {
	private static final int WIDTH = 50;
	private Point location;
	private List<Figure> children;

	public ArrayFigure(int x, int y) {
		location = new Point(x, y);
		children = new ArrayList<>();
		StandardColor[] values = StandardColor.values();
		for (int i = 0; i < values.length; i++)
			addPosition(values[i]);
	}

	public void addPosition(StandardColor color) {
		int i = children.size() / 2;
		Square square = new Square(WIDTH);
		square.setColor(color);
		square.move(i * WIDTH, 0);
		children.add(square);
		children.add(new StaticText(i, i * WIDTH + WIDTH / 2, WIDTH + 10));
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public List<? extends Figure> getChildFigures() {
		return Collections.unmodifiableList(children);
	}

	public void move(int x, int y) {
		location = location.sum(x, y);
	}
}