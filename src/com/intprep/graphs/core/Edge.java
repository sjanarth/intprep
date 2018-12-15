package com.intprep.graphs.core;

public class Edge<T> 
{
	public Edge (T f, T t, int w) {
		from = f;
		to = t;
		weight = w;
	}
	
	public Edge (T f, T t)	{
		this (f, t, 0);
	}
	
	public T getFrom() {
		return from;
	}

	public T getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int w) {
		weight = w;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals (Object o)	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		Edge<T> e = (Edge<T>) o;
		return (from.equals(e.getFrom()) && to.equals(e.getTo()));
	}
	
	@Override
	public int hashCode() {
		return from.hashCode() + to.hashCode();
	}	
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(from); sb.append("->");sb.append(to);
		sb.append(":"); sb.append(weight);
		sb.append("}");
		return sb.toString();
	}

	private T from = null;
	private T to = null;
	private int weight = 0;
}
