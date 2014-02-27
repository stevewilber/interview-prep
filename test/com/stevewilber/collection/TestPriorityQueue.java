package com.stevewilber.collection;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stevewilber.collection.PriorityQueue;

public class TestPriorityQueue {

	@Test
	public void test() {
		PriorityQueue myQueue = new PriorityQueue();
		java.util.PriorityQueue<Integer> utilQueue = new java.util.PriorityQueue<Integer>();
		
		for (int i = 0; i < 100000; i++) {
			int num = (int) (Math.random() * 10000);
			myQueue.insert(num);
			utilQueue.add(num);
		}
		
		while(!utilQueue.isEmpty()) {
			int num = utilQueue.remove();
			assertEquals(num, myQueue.extractMin());
			assertEquals(utilQueue.size(), myQueue.size());
		}
	}

}
