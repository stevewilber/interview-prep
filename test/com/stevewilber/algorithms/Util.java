package com.stevewilber.algorithms;

import java.util.Arrays;

public class Util {
	public static int[] generateArray(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 1000);
		}
		return arr;
	}

	public static int[] createSortedCopy(int[] arr) {
		int[] sorted = new int[arr.length];
		System.arraycopy(arr, 0, sorted, 0, arr.length);
		Arrays.sort(sorted);
		return sorted;
	}

}
