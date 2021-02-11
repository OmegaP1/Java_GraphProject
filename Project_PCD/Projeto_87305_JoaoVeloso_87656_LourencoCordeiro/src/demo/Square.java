package demo;
import java.util.*;
import pt.iscte.guitoo.*;

public class Square implements PolylineFigure {
	private List<Point> points;
	private Color color;
	private Point location;

	public Square(int side) {
		location = Point.ORIGIN;
		points = new ArrayList<>(4);
		points.add(Point.ORIGIN);
		points.add(new Point(side - 1, 0));
		points.add(new Point(side - 1, side - 1));
		points.add(new Point(0, side - 1));
		color = StandardColor.GRAY;
	}

	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	@Override
	public Color getFillColor() {
		return color;
	}

	public void move(int x, int y) {
		location = location.sum(x, y);
	}

	public void setColor(Color color) {
		this.color = color;
	}
}