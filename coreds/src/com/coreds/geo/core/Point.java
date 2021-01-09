package com.coreds.geo.core;

public class Point 
{
	public Point (int x1, int y1) { x = x1; y = y1; }
	
	public static Point fromPolar (double r, double t) {
		return new Point (((int) (r * Math.cos(t))), ((int) (r * Math.sin(t)))); 
	}
	
	public int getX() {	return x; }
	public int getY() { return y; }
	
	public double getR() { return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); }
	public double getT() { return (1 / Math.tan( y / x)); }
	
	@Override
	public boolean equals (Object o)	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		Point c = (Point) o;
		return (x == c.x && y == c.y);
	}
	
	@Override
	public int hashCode() {
		int result = x;
		result = 11 * result + y;
		return result;
	}	
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		sb.append("("); sb.append(x); sb.append(","); sb.append(y); sb.append(")");
		return sb.toString();
	}

	private int x = -1;
	private int y = -1;
}