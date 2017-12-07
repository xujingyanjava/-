package com.yanblog.base.utils.redis;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisPoolUtil {
	
	public static Logger log = Logger.getLogger(JedisPoolUtil.class);
	
    private static Object[][] ipports;
    
    private static Map<String, JedisPool> pools = new HashMap<String, JedisPool>();
    
    private static ConsistentHash<String> consistentHash = null;
    
    //public static final String PASSWORD = "@WSXzaq1";//requirepass @WSXzaq1
	
    public static synchronized Jedis createJedis(String host, int port, String passwrod) {
        Jedis jedis = new Jedis(host, port);
        
        if (!StringUtils.isNotBlank(passwrod))
            jedis.auth(passwrod);
        
        return jedis;
    }
    
    /**
     * 建立连接池 真实环境，一般把配置参数缺抽取出来。
     * 
     */
    public static void createJedisPool(Object[][] ipports) {
    	
    	JedisPoolUtil.ipports = ipports;
    	
    	List<String> list = new ArrayList<String>();
    	
    	for (int i = 0; i < ipports.length; i++) {
    		String ip = ipports[i][0].toString();
    		int port = Integer.parseInt(ipports[i][1].toString());
    		 // 建立连接池配置参数
            JedisPoolConfig config = new JedisPoolConfig();
            
            
            // 设置最大连接数
            config.setMaxActive(100);
            //config.setMaxTotal(100);
            
            // 设置最大阻塞时间，记住是毫秒数milliseconds
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWait(500);
            //config.setMaxWaitMillis(5*60*1000);
            
            // 设置空间连接
            config.setMaxIdle(20);
            
            
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);
            
            //逐出连接的最小空闲时间
            config.setMinEvictableIdleTimeMillis(30*60*1000);//三十分钟
            //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程
            config.setTimeBetweenEvictionRunsMillis(20*60*1000);//20分钟
            
            // 创建连接池
            //JedisPool pool = new JedisPool(config, ip, port);
            JedisPool pool = new JedisPool(config, ip, port,500,"jock@123");
            pools.put(ip+":"+port, pool);
            list.add(ip+":"+port);
		}
    	consistentHash = new ConsistentHash<String>(new HashFunction(), 9, list);
    	
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInitJedis() {
        if (pools == null)
            createJedisPool(ipports);
    }

    /**
     * 获取一个jedis 对象
     * 
     * @return
     */
    public static Jedis getJedis(String key) {

        if (pools == null)
            poolInitJedis();
        String ip = consistentHash.get(key);
        //System.out.println(key+"-"+ip);
        try{
        	return pools.get(ip).getResource();
        	
        }catch(JedisConnectionException ce){
        	log.error("redis 连接超时,error",ce);
        	ce.printStackTrace();
        	//加入系统预警
        	SysErrMsgUtil.sendSysErrMsg(1, 4, "redis 连接超时");
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * 归还一个连接
     * 
     * @param jedis
     */
    public static void returnResJedis(Jedis jedis,String key) {
        //pool.returnResource(jedis);
    	String ip = consistentHash.get(key);
    	if (jedis != null)
    		pools.get(ip).returnResourceObject(jedis);
    }
    
}
