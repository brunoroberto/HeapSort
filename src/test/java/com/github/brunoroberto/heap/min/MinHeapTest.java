package com.github.brunoroberto.heap.min;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import javax.naming.LimitExceededException;

import org.junit.jupiter.api.Test;

import com.github.brunoroberto.heap.Heap;

public class MinHeapTest {

	@Test
	public void testMinHeapCapacityArg() {
		Integer[] expecteds = { 1, 2, 5, 4, 3, 9, 6, 10, 7, 8 };
		Heap<Integer> minHeap = new MinHeap<>(expecteds.length);
		try {
			minHeap.add(10);
			minHeap.add(9);
			minHeap.add(8);
			minHeap.add(7);
			minHeap.add(6);
			minHeap.add(5);
			minHeap.add(4);
			minHeap.add(3);
			minHeap.add(2);
			minHeap.add(1);

			Comparable<Integer>[] actuals = minHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMinHeapCapacityArgSort() {
		Integer[] expecteds = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Heap<Integer> minHeap = new MinHeap<>(expecteds.length);
		try {
			minHeap.add(10);
			minHeap.add(9);
			minHeap.add(8);
			minHeap.add(7);
			minHeap.add(6);
			minHeap.add(5);
			minHeap.add(4);
			minHeap.add(3);
			minHeap.add(2);
			minHeap.add(1);

			minHeap.sort();

			Comparable<Integer>[] actuals = minHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMinHeapDefaultCapacityArg() {
		Integer[] expecteds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Heap<Integer> minHeap = new MinHeap<>();
		try {

			for (int i = 1; i <= minHeap.getCapacity(); i++)
				minHeap.add(i);

			Comparable<Integer>[] actuals = minHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMinHeapDefaultCapacityArgSort() {
		Integer[] expecteds = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Heap<Integer> minHeap = new MinHeap<>();
		try {

			for (int i = 1; i <= minHeap.getCapacity(); i++)
				minHeap.add(i);

			minHeap.sort();

			Comparable<Integer>[] actuals = minHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMinHeapValuesArg() {
		Integer[] expecteds = { 1, 2, 4, 3, 6, 5, 8, 10, 7, 9 };
		Integer[] values = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Heap<Integer> minHeap = new MinHeap<>(values);
		Comparable<Integer>[] actuals = minHeap.getValues();
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testMinHeapValuesArgSort() {
		Integer[] expecteds = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Integer[] values = { 1, 2, 4, 3, 6, 5, 8, 10, 7, 9 };
		Heap<Integer> minHeap = new MinHeap<>(values);
		minHeap.sort();
		Comparable<Integer>[] actuals = minHeap.getValues();
		assertArrayEquals(expecteds, actuals);
	}

}
