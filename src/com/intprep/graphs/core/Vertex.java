package com.intprep.graphs.core;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> 
{
	public Vertex (T lbl) {
		label = lbl;
		neighbors = new ArrayList<Vertex<T>>();
	}
	
	public T getLabel() {
		return label;
	}

	public T setLabel(T lbl) {
		T old = label;
		label = lbl;
		return old;
	}
	
	public List<Vertex<T>> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor (Vertex<T> v) {
		neighbors.add(v);
	}
	
	protected T label;
	protected List<Vertex<T>> neighbors;
}