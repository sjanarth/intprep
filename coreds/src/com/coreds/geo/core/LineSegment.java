package com.coreds.geo.core;

public class LineSegment {
	
	public LineSegment (Point a, Point b) { p1 = a; p2 = b; }
	public LineSegment (int x1, int y1, int x2, int y2)	{ p1 = new Point (x1,y1); p2 = new Point (x2,y2); }
	
	public Point getP1() { return p1; }
	public Point getP2() { return p2; }
	public int getX1() { return p1.getX(); }
	public int getY1() { return p1.getY(); }
	public int getX2() { return p2.getX(); }
	public int getY2() { return p2.getY(); }
	
	@Override
	public boolean equals (Object o)	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		LineSegment ls = (LineSegment) o;
		return (p1.equals(ls.getP1()) && p2.equals(ls.getP2())); 
	}
	
	@Override
	public int hashCode() {
		int result = p1.hashCode();
		result = 21 * result + p2.hashCode();
		return result;
	}	
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		sb.append("{"); sb.append(p1.toString()); sb.append(p2.toString()); sb.append("}");
		return sb.toString();
	}
	

	private Point p1 = null;
	private Point p2 = null;
}
