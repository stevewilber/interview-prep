package com.stevewilber.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a priority queue using a binary heap. Insert and extract run
 * in O(log n) since the tree needs to be adjusted to re-establish the heap property
 * 
 * I used this as a reference: http://www.cs.cornell.edu/courses/cs312/2007sp/lectures/lec25.html
 * 
 * @author swilber
 *
 */
public class PriorityQueue {
	private List<Integer> heap = new ArrayList<Integer>();
	
	public void insert(int num) {
		heap.add(heap.size(), num);
		bubbleUp(heap.size()-1);
	}
	
	public int extractMin() {
		int min = heap.get(0);
		int num = heap.remove(heap.size() - 1);
		if (heap.size() > 0) {
			heap.set(0, num);
			bubbleDown(0);
		}
		return min;
	}
	
	public int size() {
		return heap.size();
	}
	
	private void bubbleUp(int i) {
		if (i <= 0) {
			return;
		}
		
		int parentIndex = (i-1)/2;
		int num = heap.get(i);
		int parentNum = heap.get(parentIndex);
		if (num < parentNum) {
			heap.set(parentIndex, num);
			heap.set(i, parentNum);
			bubbleUp(parentIndex);
		}
	}
	
	private void bubbleDown(int i) {
		if (2*i + 1 >= heap.size()) {
			return;
		}
		
		int num = heap.get(i);
		int leftChildIndex = 2*i + 1;
		int rightChildIndex = 2*i + 2;
		int leftChild = heap.get(leftChildIndex);
		int rightChild = rightChildIndex < heap.size() ? heap.get(rightChildIndex) : Integer.MAX_VALUE;

		if (num > Math.min(leftChild, rightChild)) {
			if (leftChild < rightChild) {
				heap.set(leftChildIndex, num);
				heap.set(i, leftChild);
				bubbleDown(leftChildIndex);
			} else {
				heap.set(rightChildIndex, num);
				heap.set(i, rightChild);
				bubbleDown(rightChildIndex);
			}
		}
	}
}
