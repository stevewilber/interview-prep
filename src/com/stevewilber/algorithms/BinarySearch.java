package com.stevewilber.algorithms;

/**
 * Binary search - iterative and recursive implementations. Finds an int
 * in a sorted array in O(log n) time.
 * 
 * @author swilber
 */
public class BinarySearch {
	public int indexOf(int num, int[] sortedArray) {
		return search(num, sortedArray, 0, sortedArray.length - 1);
	}

	public int indexOfRecursive(int num, int[] sortedArray) {
		return searchRecursive(num, sortedArray, 0, sortedArray.length - 1);
	}

	private int search(int num, int[] sortedArray, int iMin, int iMax) {
		while (iMax >= iMin) {
			int iMid = (iMin + iMax) / 2;
			if (num > sortedArray[iMid]) {
				iMin = iMid + 1;
			} else if (num < sortedArray[iMid])  {
				iMax = iMid - 1;
			} else {
				return iMid;
			}
		}

		return -1;
	}
	
	private int searchRecursive(int num, int[] sortedArray, int iMin, int iMax) {
		if (iMax < iMin) {
			return -1;
		}
		
		int iMid = (iMin + iMax) / 2;
		if (sortedArray[iMid] < num) {
			return searchRecursive(num, sortedArray, iMid + 1, iMax);
		} else if (sortedArray[iMid] > num)  {
			return searchRecursive(num, sortedArray, iMin, iMid - 1);
		} else {
			return iMid;
		}
	}
	

}
