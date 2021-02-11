package figuras;

import java.util.ArrayList;
import java.util.List;
import pt.iscte.guitoo.*;

public class Circle implements PolylineFigure {

	private ArrayList<Point> create = new ArrayList<>();
	private Point location = new Point(1, 0);
	private Color color = StandardColor.WHITE;
	int n = 1;

	public Circle(int x, int y) {			
		create.add(new Point(x-2,y-5));
		create.add(new Point(x+2,y-5));
		create.add(new Point(x+4,y-2));
		create.add(new Point(x+4,y+2));
		create.add(new Point(x+2,y+5));
		create.add(new Point(x-2,y+5));
		create.add(new Point(x-4,y+2));
		create.add(new Point(x-4,y-2));
	}

	public Color getFillColor() {
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void ChangePosition(int x, int y) {
		this.location = location.sum(x, y);
	}

	public List<? extends Location> getPoints() {
		return create;
	}
	
	public void setSize(int n) {
		
	}

}