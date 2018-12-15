package com.intprep.graphs.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.intprep.graphs.core.Position;

/*
 * You are given a NxN chess board and a knight that moves like in normal chess. 
 * Currently the knight is at starting position denoted by (start_row, start_col)
 * and wants to reach the ending position denoted by (end_row, end_col).  
 * The goal is to calculate the minimum number of moves that the knight needs to 
 * take to get from starting position to ending position.
 * 
 * Input Format:
 * 		n -- size of the chess board 4 <= n <= 8
 * 		startPos -- starting position
 * 		endPos -- ending position
 * Output Format:
 * 		Return an integer.
 * 			-- If it is possible to reach from start to end then return minimum 
 * 			   number of moves that the knight needs to take to get from start to end;
 * 			-- If it is not possible to reach from start to end then return -1.
 */
public class KnightsTour 
{
	public static void main (String[] args) {
		findShortestPath (8, new Position(3,4), new Position(5,1));
		findShortestPath (8, new Position(0,0), new Position(7,7));
	} 
	
	private static void findShortestPath (int N, Position start, Position end) {
		Map<Position, Integer> distances = initDistanceMap(N, start);
		Map<Position, Position> backRefs = new HashMap<Position,Position>();
		backRefs.put(start, null);
		Queue<Position> queue = new LinkedList<Position>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Position curPos = queue.poll();
			//System.out.println(curPos.toString());
			if (curPos.equals(end))	{
				System.out.print(distances.get(curPos)+" moves ");
				printPathInReverse(backRefs, end);
				return;
			}
			for (int[] move : VALID_MOVES) {
				Position newPos = new Position(curPos.getRow()+move[0], curPos.getCol()+move[1]);
				if (isSafe(N, newPos) && distances.get(newPos) == -1)	{
					queue.add(newPos);
					distances.put(newPos, distances.get(curPos)+1);
					if (!backRefs.containsKey(newPos))
						backRefs.put(newPos, curPos);
				}
			}
		}
		System.out.println("No valid paths exist");
	}
	
	private static void printPathInReverse (Map<Position,Position> backRefs, Position end) {
		Stack<Position> stack = new Stack<Position>();
		Position p = end;
		while (p != null) {
			stack.push(p);
			p = backRefs.get(p);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().toString()+" ");
		}
		System.out.println();
	}
	
	private static Map<Position,Integer> initDistanceMap (int N, Position start)	{
		Map<Position,Integer> distances = new HashMap<Position,Integer>();
		for (int i = 0; i < N; i++)	{
			for(int j = 0; j < N; j++) {
				Position p = new Position(i,j);
				int dist = -1;
				if (p.equals(start)) dist = 0;
				distances.put(p,  dist);
			}
		}
		return distances;
	}
	
	private static boolean isSafe (int N, Position c) {
		return (c.getCol() >= 0 && c.getCol() < N &&
				c.getRow() >= 0 && c.getRow() < N);
	}

	private static final int[][] VALID_MOVES = new int[][] {
			{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}
		};
}