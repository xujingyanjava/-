package com.yanblog.base.utils.redis;


public class HashFunction {
	
	public int hash(String data) {
		return HashAlgorithms.FNVHash1(data);
	}
	
	public int hash(Object o) {
		return HashAlgorithms.FNVHash1(o.toString());
	}
}
