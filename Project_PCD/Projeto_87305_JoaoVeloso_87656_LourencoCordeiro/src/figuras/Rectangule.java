package figuras;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.guitoo.*;

public class Rectangule implements PolylineFigure {

	private ArrayList<Point> create = new ArrayList<>();
	private Point location = Point.ORIGIN;
	private Color color = StandardColor.WHITE;

	public Rectangule(int x, int y) {
		create.add(Point.ORIGIN);
		create.add(new Point(x, 0));
		create.add(new Point(x, y));
		create.add(new Point(0, y));
	}

	public Color getFillColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void changePosition(int x, int y) {
		this.location = location.sum(x, y);
	}

	public List<? extends Location> getPoints() {
		return create;
	}

}
