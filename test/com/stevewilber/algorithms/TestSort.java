package com.stevewilber.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestSort {
	private static final int LENGTH = 1000;
	
	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			testMergeSort();
			testQuickSort();
		}
	}
	
	@Test
	public void testMergeSort() {
		int[] arr = Util.generateArray(LENGTH);
		int[] sorted = Util.createSortedCopy(arr);
		new Sort().mergeSort(arr);
		assertTrue(Arrays.equals(arr, sorted));
	}

	@Test
	public void testQuickSort() {
		int[] arr = Util.generateArray(LENGTH);
		int[] sorted = Util.createSortedCopy(arr);
		new Sort().quickSort(arr);
		assertTrue(Arrays.equals(arr, sorted));
	}
	
	@Test
	public void testSlowSort() {
		int[] arr = Util.generateArray(12);
		int[] sorted = Util.createSortedCopy(arr);
		new Sort().slowSort(arr);
		System.out.println(Arrays.toString(arr));
		assertTrue(Arrays.equals(arr, sorted));
	}

}
