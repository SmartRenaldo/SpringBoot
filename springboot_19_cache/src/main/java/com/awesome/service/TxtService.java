package com.awesome.service;

public interface TxtService {
    String get(String phoneNum);
    boolean check(String phoneNum, String VCode);
}
