package com.coreds.graphs.core;

public class Position 
{
	public Position(int r, int c) {
		row = r;
		col = c;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	@Override
	public boolean equals (Object o)	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		Position p = (Position) o;
		return (row == p.row && col == p.col);
	}
	
	@Override
	public int hashCode() {
		int result = row;
		result = 31 * result + col;
		return result;
	}	
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		sb.append("{"); sb.append(row); sb.append(","); sb.append(col); sb.append("}");
		return sb.toString();
	}

	private int row = -1;
	private int col = -1;
}
