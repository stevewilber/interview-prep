package com.stevewilber.algorithms;


/**
 * A few implementations of sorting an array of integers  
 * 
 * @author swilber
 */
public class Sort {

	/**
	 * An implementation of quick sort, runs in O(n log n)
	 * 
	 * @param arr
	 */
	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length);
	}
	
	private void quickSort(int[] arr, int offset, int length) {
		if (length <= 1) {
			return;
		}
		
		//choose pivot and put at beginning of sub-array
		int p = offset + (int) (Math.random() * length);
		swap(arr, offset, p);
		p = offset;
		
		//partition array around pivot
		for (int i = offset + 1; i < offset + length; i++) {
			if (arr[i] < arr[offset]) {
				p++;
				swap(arr, i, p);
			}
		}
		
		//move pivot into correct spot
		swap(arr, offset, p);
		
		//sort left of pivot
		quickSort(arr, offset, p - offset);
		
		//sort right of pivot
		quickSort(arr, p + 1, offset + length - p - 1);
	}
	
	private void swap(int[] arr1, int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp;
	}
	
	/**
	 * An implementation of merge sort, runs in O(n log n)
	 * 
	 * @param arr
	 */
	public void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] dest = new int[arr.length];
			mergeSort(arr, 0, arr.length - 1, dest);
			System.arraycopy(dest, 0, arr, 0, arr.length);
		}
	}

	private void mergeSort(int[] arr, int min, int max, int[] dest) {
		if (max - min < 1) {
			return;
		}
			
		int mid = (min + max) / 2;
		mergeSort(arr, min, mid, dest);
		mergeSort(arr, mid + 1, max, dest);
		merge(arr, min, mid, max, dest);
		System.arraycopy(dest, min, arr, min, max - min + 1);
	}
	
	private void merge(int[] arr, int min, int mid, int max, int[] dest) {
		for (int i = min, j = min, k = mid + 1; i <= max; i++) {
			if (j > mid || (k <= max && arr[k] < arr[j])) {
				dest[i] = arr[k];
				k++;
			} else {
				dest[i] = arr[j];
				j++;
			}
		}
	}
	
	/**
	 * I was amused by the idea of implementing the worst sorting
	 * algorithm I could think of. This is super brute force search: permute the
	 * array until it is sorted. Runs in O(n * n!), take ~30s to sort a 13 element
	 * array on my 2.5Ghz Core i7
	 * 
	 * @param arr
	 */
	public void slowSort(int[] arr) {
		tryPermutation(arr, 0);
	}
	
	private boolean tryPermutation(int[] arr, int p) {
		if (isSorted(arr)) {
			return true;
		}
		
		for (int i = p; i < arr.length; i++) {
			swap(arr, i, p);
			if(!tryPermutation(arr, p + 1)) {
				swap(arr, p, i);
			} else {
				return true;
			}
		}
		
		return false;
	}

	private boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
