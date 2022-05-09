package com.awesome.service.impl;

import com.awesome.domain.VCode;
import com.awesome.service.VCodeService;
import com.awesome.utils.VCodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class VCodeServiceImpl implements VCodeService {

    @Autowired
    private VCodeUtils vCodeUtils;

//    @Override
//    @CachePut(value = "vCode", key = "#phone")
//    public String sendCode(String phone) {
//        return vCodeUtils.generator(phone);
//    }
//
//    @Override
//    public boolean check(VCode vCode) {
//        String code = vCode.getVCode();
//        String cachedCode = vCodeUtils.get(vCode.getPhone());
//        return code.equals(cachedCode);
//    }

    @Autowired
    private MemcachedClient memcachedClient;

    //memcached
    @Override
    public String sendCode(String phone) {
        String code = vCodeUtils.generator(phone);
        try {
            memcachedClient.set(phone, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean check(VCode vCode) {
        String string = null;

        try {
            string = memcachedClient.get(vCode.getPhone()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vCode.getVCode().equals(string);
    }
}
