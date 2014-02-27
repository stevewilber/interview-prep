package com.stevewilber.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestBinarySearch {

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			doTest();
		}
	}

	private void doTest() {
		int[] arr = Util.generateArray(100);
		Arrays.sort(arr);
		int num = (int) (Math.random() * 1000);
		int result = new BinarySearch().indexOf(num, arr);
		int resultRecursive = new BinarySearch().indexOfRecursive(num, arr);
		assertEquals(result, resultRecursive);
		if (result == -1) {
			assertTrue(Arrays.binarySearch(arr, num) < 0);
		} else {
			assertEquals(arr[result], num);
		}
	}


}
