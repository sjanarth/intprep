package com.intprep.geo.problems.lines;

import com.intprep.geo.core.Point;
import com.intprep.geo.core.LineSegment;

public class IntersectingLines 
{
	public static void main (String[] args) {
		doLinesIntersect (new LineSegment (2,2,9,2), new LineSegment(3,7,3,1));
		doLinesIntersect (new LineSegment (2,2,9,2), new LineSegment(2,4,9,4));
	}
	
	private static boolean doLinesIntersect (LineSegment ls1, LineSegment ls2) {
		System.out.print("doLinesIntersect("+ls1.toString()+","+ls2.toString()+": ");
		// Find the four orientations needed for general and 
	    int o1 = getOrientation(ls1.getP1(), ls1.getP2(), ls2.getP1()); 
	    int o2 = getOrientation(ls1.getP1(), ls1.getP2(), ls2.getP2()); 
	    int o3 = getOrientation(ls2.getP1(), ls2.getP2(), ls1.getP1()); 
	    int o4 = getOrientation(ls2.getP1(), ls2.getP2(), ls1.getP2()); 
	  
	    boolean retVal = false;
	    // General case 
	    if (o1 != o2 && o3 != o4) 
	    	retVal = true; 
	  	// Special Cases 
	    // x1, y1 and x2 are colinear and x2 lies on segment x1y1 
	    else if (o1 == 0 && isPointOnLine(ls1.getP1(), ls2.getP1(), ls1.getP2())) retVal = true; 
	    // x1, y1 and y2 are colinear and y2 lies on segment x1y1 
	    else if (o2 == 0 && isPointOnLine(ls1.getP1(), ls2.getP2(), ls1.getP2())) retVal = true; 
	    // x2, y2 and x1 are colinear and x1 lies on segment x2y2 
	    else if (o3 == 0 && isPointOnLine(ls2.getP1(), ls1.getP1(), ls2.getP2())) retVal = true; 
	    // x2, y2 and y1 are colinear and y1 lies on segment x2y2 
	    else if (o4 == 0 && isPointOnLine(ls2.getP1(), ls1.getP2(), ls2.getP2())) retVal = true; 
	  
	    System.out.println(retVal);
	    return retVal; // Doesn't fall in any of the above cases 		
	}
	
	private static int getOrientation (Point p, Point q, Point r)	{
	    int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - 
	    			(q.getX() - p.getX()) * (r.getY() - q.getY()); 
	    if (val == 0) return 0;  // colinear 
	    return (val > 0) ? 1: 2; // clock or counterclock wise		
	}

	private static boolean isPointOnLine (Point p, Point q, Point r)	{
		return (q.getX() <= Math.max(p.getX(), r.getX()) && 
				q.getX() >= Math.min(p.getX(), r.getX()) && 
		        q.getY() <= Math.max(p.getY(), r.getY()) && 
		        q.getY() >= Math.min(p.getY(), r.getY()));
	}
	
}
	