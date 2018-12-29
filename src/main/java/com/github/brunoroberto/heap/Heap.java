package com.github.brunoroberto.heap;

import javax.naming.LimitExceededException;

/**
 * 
 * Heap is basically a binary tree using an array. There are two kinds of heaps:
 * max and min
 * 
 * In the max heaps the parent's node must be greater than the children. In the
 * min heaps is the inverse, the parent's node must be less than the children
 * 
 * @author brunoroberto
 *
 * @param <T>
 */
public abstract class Heap<T extends Comparable<T>> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CHILDREN_NODE = 2;

	protected T[] values;
	protected int capacity;
	protected int size;

	@SuppressWarnings("unchecked")
	public Heap() {
		this.values = (T[]) new Comparable[DEFAULT_CAPACITY];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		this.values = (T[]) new Comparable[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public Heap(T[] values) {
		this.values = values;
		this.capacity = values.length;
		this.size = values.length;
	}

	protected int parent(int nodeIndex) {
		return (nodeIndex - 1) / MAX_CHILDREN_NODE;
	}

	protected int leftChild(int nodeIndex) {
		return (nodeIndex * MAX_CHILDREN_NODE) + 1;
	}

	protected int rightChild(int nodeIndex) {
		return (nodeIndex * MAX_CHILDREN_NODE) + 2;
	}

	public void swap(int a, int b) {
		T aux = this.values[a];
		this.values[a] = this.values[b];
		this.values[b] = aux;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public T[] getValues() {
		return this.values;
	}

	public int getSize() {
		return this.size;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public abstract void add(T element) throws LimitExceededException;

	public abstract T extract();

	public abstract void sort();
}
