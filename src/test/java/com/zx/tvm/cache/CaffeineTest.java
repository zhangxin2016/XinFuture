package com.zx.tvm.cache;


import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.security.Key;

/**
 * Created by zhangx on 2017/9/15
 */
public class CaffeineTest {
    public static void caffeineTest(){
        LoadingCache<String,Integer> graphs = Caffeine.newBuilder()
                .maximumSize(10000)
                .build(x->{
                    return x.hashCode();
                });
    }
}
