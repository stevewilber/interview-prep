package com.stevewilber.collection;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stevewilber.collection.HashMap;

public class TestHashMap {

	@Test
	public void testGetPut() {
		HashMap map = new HashMap();
		map.put("hi", "there");
		assertEquals("there", map.get("hi"));
	}

	@Test
	public void testSize() {
		HashMap map = new HashMap();
		map.put("hi", "there");
		assertEquals(1, map.size());
	}

	@Test
	public void testClear() {
		HashMap map = new HashMap();
		map.put("hi", "there");
		map.clear();
		assertEquals(0, map.size());
		assertNull(map.get("hi"));
	}
	
	@Test
	public void testCollisions() {
		HashMap map = new HashMap();
		for (int i = 0; i < 1000000; i++) {
			String key = Integer.toString(i);
			map.put(key, key);
			assertEquals(key, map.get(key));
			assertEquals(i+1, map.size());
		}
	}
	
	@Test
	public void compareSpeedWithUtil() {
		long start = System.nanoTime();
		HashMap map = new HashMap();
		for (int i = 0; i < 1000; i++) {
			String key = Integer.toString(i);
			map.put(key, key);
			assertEquals(key, map.get(key));
			assertEquals(i+1, map.size());
		}
		System.out.println("mine: " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		java.util.HashMap<String, String> utilMap = new java.util.HashMap<String, String>();
		for (int i = 0; i < 1000; i++) {
			String key = Integer.toString(i);
			utilMap.put(key, key);
			assertEquals(key, utilMap.get(key));
			assertEquals(i+1, utilMap.size());
		}
		System.out.println("util: " + (System.nanoTime() - start));
	}

}
