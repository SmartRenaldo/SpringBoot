package com.awesome.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class VCodeUtils {

    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String phone) {
        int hash = phone.hashCode();
        int encryption = 20220509;
        long result = hash ^ encryption;
        long now = System.currentTimeMillis();
        result = result ^ now;
        long code = result % 1000000;
        code = Math.abs(code);
        String codeStr = code + "";
        int len = codeStr.length();

        return patch[len] + codeStr;
    }

    @Cacheable(value = "vCode", key = "#phone")
    public String get(String phone) {
        return null;
    }
}
