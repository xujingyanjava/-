package com.yanblog.base.utils.redis;

import java.util.*;

/**
 * 一致性hash算法
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public class ConsistentHash<T> {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("192.168.124.129");
		list.add("192.168.124.130");
		list.add("192.168.124.131");
		ConsistentHash<String> ConsistentHash = new ConsistentHash<String>(new HashFunction(), 3, list);
		
		for (int i = 0; i < 10; i++) {
			//String key = "t" + i + "est" + (i+10) ;
			String key = UUID.randomUUID().toString();
			System.out.println(key + " - " + ConsistentHash.get( key ) );
		}
		
	}
	
	private final HashFunction hashFunction;
	private final int numberOfReplicas;
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();

	public ConsistentHash(HashFunction hashFunction, int numberOfReplicas,
						  Collection<T> nodes) {
		this.hashFunction = hashFunction;
		this.numberOfReplicas = numberOfReplicas;

		for (T node : nodes) {
			add(node);
		}
	}

	public void add(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.put(hashFunction.hash(node.toString() + i), node);
		}
	}

	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove(hashFunction.hash(node.toString() + i));
		}
	}

	public T get(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
		int hash = hashFunction.hash(key);
		if (!circle.containsKey(hash)) {
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}

}