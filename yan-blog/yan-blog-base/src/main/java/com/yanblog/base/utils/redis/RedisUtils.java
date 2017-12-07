package com.yanblog.base.utils.redis;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtils {

	private static RedisUtils shardingJedis;

	static {

		String redis_host = "101.200.33.154:6378";
		String[] redis_hosts = redis_host.split(",");
		Object[][] ipports = new Object[redis_hosts.length][2];
		for (int i = 0; i < redis_hosts.length; i++) {
			String[] tmp = redis_hosts[i].split(":");
			ipports[i][0] = tmp[0];
			ipports[i][1] = Integer.parseInt(tmp[1]);
		}

		getInstance(ipports);

	}

	private static synchronized RedisUtils getInstance(Object[][] ipports) {
		if( null == shardingJedis ) {
			shardingJedis = new RedisUtils(ipports);
		}
		return shardingJedis;
	}

	public static synchronized RedisUtils getInstance() {
		return shardingJedis;
	}

	private RedisUtils(Object[][] ipports) {
		JedisPoolUtil.createJedisPool(ipports);
	}

	public Jedis getJedis(String key) {
		Jedis jredis = JedisPoolUtil.getJedis(key);
		//jredis.auth(PASSWORD);
		return jredis;
	}

	public void returnJedis(Jedis jedis,String key) {
		JedisPoolUtil.returnResJedis(jedis, key);
	}


	public String set(byte[] key, byte[] value){
		try{
			del(key);
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			String val = jedis.set(key, value);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public byte[] get(byte[] key) {
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			byte[] val = jedis.get(key);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public Boolean exists(byte[] key){
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Boolean val = jedis.exists(key);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;

	}

	public Long persist(byte[] key){
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Long val = jedis.persist(key);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;


	}

	public Long append(byte[] key, byte[] value){
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Long val = jedis.append(key,value);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;

	}

	public Long del(byte[] key) {
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Long val = jedis.del(key);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String set(String key, String value) {
		String val = null;
		try{
			del(key);
			Jedis jedis = getJedis(key);
			val = jedis.set(key, value);
			returnJedis(jedis, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return val;
	}


	public String set(String key, String value, String nxxx, String expx,
			long time) {
		Jedis jedis = getJedis(key);
		String val = jedis.set(key, value, nxxx,expx,time);
		returnJedis(jedis, key);
		return val;
	}


	public String get(String key) {
		String val = null;
		try{
			Jedis jedis = getJedis(key);
			val = jedis.get(key);
			returnJedis(jedis, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return val;
	}


	public Boolean exists(String key) {
		Jedis jedis = getJedis(key);
		boolean val = jedis.exists(key);
		returnJedis(jedis, key);
		return val;
	}


	public Long persist(String key) {
		Jedis jedis = getJedis(key);
		long val = jedis.persist(key);
		returnJedis(jedis, key);
		return val;
	}


	public String type(String key) {
		Jedis jedis = getJedis(key);
		String val = jedis.type(key);
		returnJedis(jedis, key);
		return val;
	}

	/**
	 * 设置存活时长 单位为秒
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key, int seconds) {
		Long val = null;
		try{
			Jedis jedis = getJedis(key);
			val = jedis.expire(key,seconds);
			returnJedis(jedis, key);
		}catch(Exception e){
			e.printStackTrace();
		}

		return val;
	}

	/**
	 * 设置存活时长 单位为秒
	 * @param key
	 * @param seconds
	 * @return
	 * @throws java.io.UnsupportedEncodingException
	 */
	public Long expire(byte[] key, int seconds) {
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Long val = jedis.expire(key,seconds);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Long expireAt(byte[] key, long unixTime) {
		try{
			Jedis jedis = getJedis(new String(key,"UTF-8"));
			Long val = jedis.expireAt(key,unixTime);
			returnJedis(jedis, new String(key,"UTF-8"));
			return val;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Long expireAt(String key, long unixTime) {
		Jedis jedis = getJedis(key);
		Long val = jedis.expireAt(key,unixTime);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long ttl(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.ttl(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Boolean setbit(String key, long offset, boolean value) {
		Jedis jedis = getJedis(key);
		Boolean val = jedis.setbit(key,offset,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Boolean setbit(String key, long offset, String value) {
		Jedis jedis = getJedis(key);
		Boolean val = jedis.setbit(key,offset,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Boolean getbit(String key, long offset) {
		Jedis jedis = getJedis(key);
		Boolean val = jedis.getbit(key,offset);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long setrange(String key, long offset, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.setrange(key,offset,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public String getrange(String key, long startOffset, long endOffset) {
		Jedis jedis = getJedis(key);
		String val = jedis.getrange(key,startOffset,endOffset);
		returnJedis(jedis, key);
		return val;
	}

	
	public String getSet(String key, String value) {
		Jedis jedis = getJedis(key);
		String val = jedis.getSet(key,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long setnx(String key, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.setnx(key,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public String setex(String key, int seconds, String value) {
		Jedis jedis = getJedis(key);
		String val = jedis.setex(key,seconds,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long decrBy(String key, long integer) {
		Jedis jedis = getJedis(key);
		Long val = jedis.decrBy(key,integer);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long decr(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.decr(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long incrBy(String key, long integer) {
		Jedis jedis = getJedis(key);
		Long val = jedis.incrBy(key,integer);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long incr(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.incr(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long append(String key, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.append(key,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public String substr(String key, int start, int end) {
		Jedis jedis = getJedis(key);
		String val = jedis.substr(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long hset(String key, String field, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.hset(key,field,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public String hget(String key, String field) {
		Jedis jedis = getJedis(key);
		String val = jedis.hget(key,field);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long hsetnx(String key, String field, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.hsetnx(key,field,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public String hmset(String key, Map<String, String> hash) {
		Jedis jedis = getJedis(key);
		String val = jedis.hmset(key,hash);
		returnJedis(jedis, key);
		return val;
	}

	
	public List<String> hmget(String key, String... fields) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.hmget(key,fields);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long hincrBy(String key, String field, long value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.hincrBy(key,field,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Boolean hexists(String key, String field) {
		Jedis jedis = getJedis(key);
		Boolean val = jedis.hexists(key,field);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long hdel(String key, String... field) {
		Jedis jedis = getJedis(key);
		Long val = jedis.hdel(key,field);
		returnJedis(jedis, key);
		return val;
	}
	
	
	public Long hlen(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.hlen(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> hkeys(String key) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.hkeys(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public List<String> hvals(String key) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.hvals(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = getJedis(key);
		Map<String, String> val = jedis.hgetAll(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long rpush(String key, String... string) {
		Jedis jedis = getJedis(key);
		Long val = jedis.rpush(key,string);
		returnJedis(jedis, key);
		return val;
	}

	public Long rpush(byte[] key, byte[]... string) {
		Jedis jedis = getJedis(new String(key));
		Long val = jedis.rpush(key,string);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public Long lpush(byte[] key, byte[]... string) {
		Jedis jedis = getJedis(new String(key));
		Long val = jedis.lpush(key,string);
		returnJedis(jedis, new String(key));
		return val;
	}

	public Long lpush(String key, String... string) {
		Jedis jedis = getJedis(key);
		Long val = jedis.lpush(key,string);
		returnJedis(jedis, key);
		return val;
	}
	
	public Long llen(byte[] key) {
		Jedis jedis = getJedis(new String(key));
		Long val = jedis.llen(key);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public Long llen(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.llen(key);
		returnJedis(jedis, key);
		return val;
	}

	public List<byte[]> lrange(byte[] key, long start, long end) {
		Jedis jedis = getJedis(new String(key));
		List<byte[]> val = jedis.lrange(key,start,end);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.lrange(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	public String ltrim(byte[] key, long start, long end) {
		Jedis jedis = getJedis(new String(key));
		String val = jedis.ltrim(key,start,end);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public String ltrim(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		String val = jedis.ltrim(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public String lindex(String key, long index) {
		Jedis jedis = getJedis(key);
		String val = jedis.lindex(key,index);
		returnJedis(jedis, key);
		return val;
	}

	
	public String lset(String key, long index, String value) {
		Jedis jedis = getJedis(key);
		String val = jedis.lset(key,index,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long lrem(String key, long count, String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.lrem(key,count,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public byte[] lpop(byte[] key) {
		Jedis jedis = getJedis(new String(key));
		byte[] val = jedis.lpop(key);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public String lpop(String key) {
		Jedis jedis = getJedis(key);
		String val = jedis.lpop(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public String rpop(String key) {
		Jedis jedis = getJedis(key);
		String val = jedis.rpop(key);
		returnJedis(jedis, key);
		return val;
	}

	public byte[] rpop(byte[] key) {
		Jedis jedis = getJedis(new String(key));
		byte[] val = jedis.rpop(key);
		returnJedis(jedis, new String(key));
		return val;
	}
	
	public Long sadd(String key, String... member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.sadd(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> smembers(String key) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.smembers(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long srem(String key, String... member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.srem(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public String spop(String key) {
		Jedis jedis = getJedis(key);
		String val = jedis.spop(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long scard(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.scard(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Boolean sismember(String key, String member) {
		Jedis jedis = getJedis(key);
		Boolean val = jedis.sismember(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public String srandmember(String key) {
		Jedis jedis = getJedis(key);
		String val = jedis.srandmember(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public List<String> srandmember(String key, int count) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.srandmember(key,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long strlen(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.strlen(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zadd(String key, double score, String member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zadd(key,score,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrange(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrange(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zrem(String key, String... member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zrem(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Double zincrby(String key, double score, String member) {
		Jedis jedis = getJedis(key);
		Double val = jedis.zincrby(key,score,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zrank(String key, String member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zrank(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zrevrank(String key, String member) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zrevrank(key,member);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrevrange(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrevrange(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrangeWithScores(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrangeWithScores(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrevrangeWithScores(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zcard(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zcard(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Double zscore(String key, String member) {
		Jedis jedis = getJedis(key);
		Double val = jedis.zscore(key,member);
		if(null == val) {
			val = 0.0;
		}
		returnJedis(jedis, key);
		return val;
	}

	
	public List<String> sort(String key) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.sort(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public List<String> sort(String key, SortingParams sortingParameters) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.sort(key,sortingParameters);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zcount(String key, double min, double max) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zcount(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zcount(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zcount(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrangeByScore(String key, double min, double max) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByScore(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrangeByScore(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByScore(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrevrangeByScore(String key, double max, double min) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrevrangeByScore(key,max,min);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrangeByScore(String key, double min, double max,
			int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByScore(key,min,max,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrevrangeByScore(String key, String max, String min) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrevrangeByScore(key,max,min);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrangeByScore(String key, String min, String max,
			int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByScore(key,min,max,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrevrangeByScore(String key, double max, double min,
			int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrevrangeByScore(key,max,min,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrangeByScoreWithScores(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrevrangeByScoreWithScores(key,max,min);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max, int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrevrangeByScore(String key, String max, String min,
			int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrevrangeByScore(key,max,min,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrangeByScoreWithScores(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max,
			String min) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrevrangeByScoreWithScores(key,max,min);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrangeByScoreWithScores(String key, String min,
			String max, int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrangeByScoreWithScores(key,min,max,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min, int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max,
			String min, int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<Tuple> val = jedis.zrevrangeByScoreWithScores(key,max,min,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zremrangeByRank(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zremrangeByRank(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zremrangeByScore(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zremrangeByScore(String key, String start, String end) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zremrangeByScore(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	/*
	public Long zlexcount(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zlexcount(key,min,max);
		returnJedis(jedis, key);
		return val;
	}
	
	
	public Set<String> zrangeByLex(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByLex(key,min,max);
		returnJedis(jedis, key);
		return val;
	}

	
	public Set<String> zrangeByLex(String key, String min, String max,
			int offset, int count) {
		Jedis jedis = getJedis(key);
		Set<String> val = jedis.zrangeByLex(key,min,max,offset,count);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long zremrangeByLex(String key, String min, String max) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zremrangeByLex(key,min,max);
		returnJedis(jedis, key);
		return val;
	}
	*/
	
	public Long linsert(String key, LIST_POSITION where, String pivot,
			String value) {
		Jedis jedis = getJedis(key);
		Long val = jedis.linsert(key,where,pivot,value);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long lpushx(String key, String... string) {
		Jedis jedis = getJedis(key);
		Long val = jedis.lpushx(key,string);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long rpushx(String key, String... string) {
		Jedis jedis = getJedis(key);
		Long val = jedis.rpushx(key,string);
		returnJedis(jedis, key);
		return val;
	}

	/*
	public List<String> blpop(String arg) {
		Jedis jedis = getJedis(key);
		Long val = jedis.blpop(key,min,max);
		returnJedis(jedis, key);
		return val;
	}*/

	
	public List<String> blpop(int timeout, String key) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.blpop(timeout,key);
		returnJedis(jedis, key);
		return val;
	}

	/*
	public List<String> brpop(String arg) {
		Jedis jedis = getJedis(key);
		Long val = jedis.zremrangeByLex(key,min,max);
		returnJedis(jedis, key);
		return val;
	}*/

	
	public List<String> brpop(int timeout, String key) {
		Jedis jedis = getJedis(key);
		List<String> val = jedis.brpop(timeout,key);
		returnJedis(jedis, key);
		return val;
	}


	public Long del(String key) {
		Long val = 0l;
		try {
			Jedis jedis = getJedis(key);
			val = jedis.del(key);
			returnJedis(jedis, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	/*
	public String echo(String string) {
		Jedis jedis = getJedis(key);
		String val = jedis.echo(string);
		returnJedis(jedis, key);
		return val;
	}*/

	
	public Long move(String key, int dbIndex) {
		Jedis jedis = getJedis(key);
		Long val = jedis.move(key,dbIndex);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long bitcount(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.bitcount(key);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long bitcount(String key, long start, long end) {
		Jedis jedis = getJedis(key);
		Long val = jedis.bitcount(key,start,end);
		returnJedis(jedis, key);
		return val;
	}

	/*
	public ScanResult<Entry<String, String>> hscan(String key, int cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<Entry<String, String>> val = jedis.hscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public ScanResult<String> sscan(String key, int cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<String> val = jedis.sscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public ScanResult<Tuple> zscan(String key, int cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<Tuple> val = jedis.zscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public ScanResult<Entry<String, String>> hscan(String key, String cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<Entry<String, String>> val = jedis.hscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public ScanResult<String> sscan(String key, String cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<String> val = jedis.sscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public ScanResult<Tuple> zscan(String key, String cursor) {
		Jedis jedis = getJedis(key);
		ScanResult<Tuple> val = jedis.zscan(key,cursor);
		returnJedis(jedis, key);
		return val;
	}

	
	public Long pfadd(String key, String... elements) {
		Jedis jedis = getJedis(key);
		Long val = jedis.pfadd(key,elements);
		returnJedis(jedis, key);
		return val;
	}

	
	public long pfcount(String key) {
		Jedis jedis = getJedis(key);
		Long val = jedis.pfcount(key);
		returnJedis(jedis, key);
		return val;
	}
	*/

	public long zcount(String key) {
		return zcount(key, Integer.MIN_VALUE, Double.MAX_VALUE);
	}
	
	public long zcountpage(String key,int pagesize) {
		long pagecount = (long) Math.ceil((zcount(key) * 1.0d) / pagesize);
		return pagecount;
	}
}
