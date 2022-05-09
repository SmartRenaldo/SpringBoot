package com.awesome.service;

import com.awesome.domain.VCode;

public interface VCodeService {
    String sendCode(String phone);
    boolean check(VCode vCode);
}
