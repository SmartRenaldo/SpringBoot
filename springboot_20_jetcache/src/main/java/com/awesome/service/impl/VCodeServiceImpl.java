package com.awesome.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.awesome.domain.VCode;
import com.awesome.service.VCodeService;
import com.awesome.utils.VCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VCodeServiceImpl implements VCodeService {

    @Autowired
    private VCodeUtils vCodeUtils;

    @CreateCache(name = "jetCache", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> jetCache;

    //memcached
    @Override
    public String sendCode(String phone) {
        String code = vCodeUtils.generator(phone);
        jetCache.put(phone, code);
        return code;
    }

    @Override
    public boolean check(VCode vCode) {
        String string = jetCache.get(vCode.getPhone());

        return vCode.getVCode().equals(string);
    }
}
