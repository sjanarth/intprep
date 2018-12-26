package com.intprep.graphs.core;

import java.util.LinkedHashSet;
import java.util.Set;

public class Vertex<T> 
{
	public Vertex (T lbl) {
		label = lbl;
		neighbors = new LinkedHashSet<Vertex<T>>();
	}
	
	public T getLabel() {
		return label;
	}

	public T setLabel(T lbl) {
		T old = label;
		label = lbl;
		return old;
	}
	
	public boolean hasNeighbors()	{
		return !neighbors.isEmpty();
	}
	
	public boolean hasNeighbor(Vertex<T> v)	{
		for (Vertex<T> n : neighbors)
			if (n.getLabel().equals(v.getLabel()))
				return true;
		return false;
	}
	
	public Set<Vertex<T>> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor (Vertex<T> v) {
		neighbors.add(v);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals (Object o)	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		Vertex<T> v = (Vertex<T>) o;
		return label.equals(v.getLabel());
	}
	
	@Override
	public int hashCode() {
		return label.hashCode();
	}	
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		sb.append(label.toString()+":{");
		for (Vertex<T> n : neighbors) {
			sb.append(n.getLabel()+",");
		}
		sb.append("}");
		return sb.toString();
	}
	
	protected T label;
	protected Set<Vertex<T>> neighbors;
}