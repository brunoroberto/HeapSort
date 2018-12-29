package com.github.brunoroberto.heap.min;

import javax.naming.LimitExceededException;

import com.github.brunoroberto.heap.Heap;

/**
 * This is a Min Heap implementation, so the parent's node must be less than the
 * children
 * 
 * @author brunoroberto
 *
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

	public MinHeap() {
		super();
	}

	public MinHeap(int capacity) {
		super(capacity);
	}

	public MinHeap(T[] values) {
		super(values);
		buildMinHeap();
	}

	private void buildMinHeap() {
		for (int index = this.size / 2 - 1; index >= 0; index--)
			minHeapfy(index);
	}

	private void minHeapfy(int index) {
		int leftChildIndex = leftChild(index);
		int rightChildIndex = rightChild(index);

		// is a leaf
		if (leftChildIndex >= this.size && rightChildIndex >= this.size) {
			return; // do nothing
		}

		T leftChild = null;
		if (leftChildIndex < this.size)
			leftChild = this.values[leftChildIndex];

		T rightChild = null;
		if (rightChildIndex < this.size)
			rightChild = this.values[rightChildIndex];

		int childIndex = -1;
		if (leftChild != null && rightChild != null) {
			if (isGreaterThan(rightChild, leftChild)) {
				childIndex = leftChildIndex;
			} else {
				childIndex = rightChildIndex;
			}
		} else {
			childIndex = leftChildIndex;
		}

		if (isGreaterThan(this.values[index], this.values[childIndex])) {
			swap(index, childIndex);
			minHeapfy(childIndex);
		}
	}

	private void fixMinHeapfy(int index) {
		int parentIndex = parent(index);
		if (isGreaterThan(this.values[parentIndex], this.values[index])) {
			swap(index, parentIndex);
			fixMinHeapfy(parentIndex);
		}
	}

	private boolean isGreaterThan(T o1, T o2) {
		return o1.compareTo(o2) > 0;
	}

	@Override
	public void add(T element) throws LimitExceededException {
		if (isFull()) {
			throw new LimitExceededException(String.format("heap capacity = %d", this.capacity));
		}
		int currentIndex = this.size++;
		this.values[currentIndex] = element;
		fixMinHeapfy(currentIndex);
	}

	@Override
	public T extract() {
		try {
			return this.values[0];
		} finally {
			this.values[0] = this.values[--this.size];
			this.values[this.size + 1] = null;
			buildMinHeap();
		}
	}

	@Override
	public void sort() {
		for (int i = this.size - 1; i >= 0; i--) {
			swap(0, i);
			this.size--;
			minHeapfy(0);
		}
	}

}
