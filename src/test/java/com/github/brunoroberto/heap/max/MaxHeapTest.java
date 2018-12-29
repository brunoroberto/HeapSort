package com.github.brunoroberto.heap.max;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import javax.naming.LimitExceededException;

import org.junit.jupiter.api.Test;

import com.github.brunoroberto.heap.Heap;

public class MaxHeapTest {

	@Test
	public void testMaxHeapCapacityArg() {
		Integer[] expecteds = { 50, 10, 20, 2, 4, 3 };
		Heap<Integer> maxHeap = new MaxHeap<>(expecteds.length);
		try {
			maxHeap.add(2);
			maxHeap.add(10);
			maxHeap.add(3);
			maxHeap.add(20);
			maxHeap.add(4);
			maxHeap.add(50);

			Comparable<Integer>[] actuals = maxHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMaxHeapCapacityArgSort() {
		Integer[] expecteds = { 2, 3, 4, 10, 20, 50 };
		Heap<Integer> maxHeap = new MaxHeap<>(expecteds.length);
		try {
			maxHeap.add(2);
			maxHeap.add(10);
			maxHeap.add(3);
			maxHeap.add(20);
			maxHeap.add(4);
			maxHeap.add(50);

			maxHeap.sort();

			Comparable<Integer>[] actuals = maxHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMaxHeapDefaultCapacityArg() {
		Integer[] expecteds = { 10, 9, 6, 7, 8, 2, 5, 1, 4, 3 };
		Heap<Integer> maxHeap = new MaxHeap<>();
		try {

			for (int i = 1; i <= maxHeap.getCapacity(); i++)
				maxHeap.add(i);

			Comparable<Integer>[] actuals = maxHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMaxHeapDefaultCapacityArgSort() {
		Integer[] expecteds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Heap<Integer> maxHeap = new MaxHeap<>();
		try {

			for (int i = 1; i <= maxHeap.getCapacity(); i++)
				maxHeap.add(i);

			maxHeap.sort();

			Comparable<Integer>[] actuals = maxHeap.getValues();
			assertArrayEquals(expecteds, actuals);

		} catch (LimitExceededException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testMaxHeapValuesArg() {
		Integer[] expecteds = { 10, 9, 7, 8, 5, 6, 3, 1, 4, 2 };
		Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Heap<Integer> maxHeap = new MaxHeap<>(values);
		Comparable<Integer>[] actuals = maxHeap.getValues();
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testMaxHeapValuesArgSort() {
		Integer[] expecteds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Integer[] values = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Heap<Integer> maxHeap = new MaxHeap<>(values);
		maxHeap.sort();
		Comparable<Integer>[] actuals = maxHeap.getValues();
		assertArrayEquals(expecteds, actuals);
	}

}
