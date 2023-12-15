package nextfs;

public interface Shape {
	public enum States {ORIGIN, INSIDE, OUTSIDE}
	
	public Point getOrigin();
	public int getDimension();
	public double getDistanceWithOrigin(Point point);
	public double getDistance(Point p1, Point p2);
	
	public States getState(Point point);
	
	public Shape createSubshape(Point origin, int ratio);
	
}
