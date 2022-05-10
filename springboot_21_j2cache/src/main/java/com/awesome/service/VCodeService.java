package com.awesome.service;

import com.awesome.domain.VCode;

public interface VCodeService {
    public String sendCode(String phone);
    public boolean checkCode(VCode vCode);
}
