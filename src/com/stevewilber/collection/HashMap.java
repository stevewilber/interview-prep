package com.stevewilber.collection;

/**
 * A basic implementation of a HashMap - get and put run in O(1)
 * 
 * @author swilber
 *
 */
public class HashMap implements Map {
	private Entry[] table;
	private int size;
	
	public HashMap() {
		initTable();
	}
	
	@Override
	public String get(String key) {
		Entry e = getEntry(key);
		return e != null ? e.value : null;
	}
	
	private Entry getEntry(String key) {
		int hash = hash(key);
		int index = indexFor(hash);
		if (table[index] != null) {
			for (Entry e = table[index]; e != null; e = e.next) {
				if (e.hash == hash && (e.key == key || (e.key != null && e.key.equals(key)))) {
					return e;
				}
			}
		}
		
		return null;
	}
	
	private int indexFor(int hash) {
		return hash % table.length;
	}

	private int hash(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = hash * 31 + key.charAt(i);
		}
		return hash;
	}

	@Override
	public void put(String key, String value) {
		Entry e = getEntry(key);
		if (e != null) {
			e.value = value;
			return;
		}
		
		int hash = hash(key);
		e = new Entry(key, value, hash);
		int index = indexFor(hash);
		if (table[index] != null) {
			e.next = table[index];
			table[index] = e;
		} else {
			table[index] = e;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		initTable();
	}
	
	private void initTable() {
		table = new Entry[1024];
		size = 0;
	}

	private static class Entry {
		private String key;
		private String value;
		private int hash;
		private Entry next;
		
		public Entry(String key, String value, int hash) {
			this.key = key;
			this.value = value;
			this.hash = hash;
		}
	}
}
