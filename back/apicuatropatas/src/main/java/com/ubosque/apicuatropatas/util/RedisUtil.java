package com.ubosque.apicuatropatas.util;

import com.ubosque.apicuatropatas.constant.Constante;
import redis.clients.jedis.Jedis;

public class RedisUtil {

    //Attributes
    private Jedis jedis;

    public RedisUtil(){
        setJedis(new Jedis(Constante.RedisInfo.DB_SERVER, Constante.RedisInfo.DB_PORT));
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

}
