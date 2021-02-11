package figuras;

import java.util.ArrayList;
import java.util.List;
import pt.iscte.guitoo.*;

public class Line implements PolylineFigure{
	
	private ArrayList<Point> create = new ArrayList<>();
	private Point location = new Point(1,0);
	
	public Line(Point esq , Point drt) {
		create.add(esq);
		create.add(drt);		
	}
	
	public Color getFillColor() {
		return StandardColor.BLACK;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public List<? extends Location> getPoints() {
		return create;
	}

}
