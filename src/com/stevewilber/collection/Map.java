package com.stevewilber.collection;

public interface Map {
	String get(String key);
	void put(String key, String value);
	int size();
	void clear();
}
