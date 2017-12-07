package com.yanblog.base.utils.redis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by xujingyan on 2016/12/14.
 */
public class JedisUtils {


    public static Jedis createJedis() {
        Jedis jedis = new Jedis("127.0.0.1");
        return jedis;
    }

    public static Jedis createJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);
        return jedis;
    }

    public static Jedis createJedis(String host, int port, String passwrod) {
        Jedis jedis = new Jedis(host, port);
        if (StringUtils.isNotBlank(passwrod)) {
            jedis.auth(passwrod);
        }
        return jedis;
    }

    public static void main(String[] args){
        String host="101.200.33.154";
        //连接本地的 Redis 服务
        Jedis jedis =createJedis(host,6378,"jock@123");
        //设置访问密码
        //查看服务是否运行
        System.out.println("Connection to server sucessfully");
        //查看是否能正常连接，相当于cli下的ping
        System.out.println("Server is running: "+jedis.ping());

        jedis.append("aaa","sasa");
        System.out.println(jedis.get("aaa"));


    }
}
