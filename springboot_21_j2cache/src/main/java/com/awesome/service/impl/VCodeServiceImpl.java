package com.awesome.service.impl;

import com.awesome.domain.VCode;
import com.awesome.service.VCodeService;
import com.awesome.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VCodeServiceImpl implements VCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCode(String phone) {
        String code = codeUtils.generator(phone);
        cacheChannel.set("veri", phone, code);
        return code;
    }

    @Override
    public boolean checkCode(VCode vCode) {
        String code = cacheChannel.get("veri", vCode.getPhone()).asString();
        return vCode.getCode().equals(code);
    }

}














