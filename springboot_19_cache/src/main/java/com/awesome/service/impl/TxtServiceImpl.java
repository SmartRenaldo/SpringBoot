package com.awesome.service.impl;

import com.awesome.service.TxtService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class TxtServiceImpl implements TxtService {

    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String phoneNum) {
        String random = getRandomString(4);
        cache.put(phoneNum, random);
        return random;
    }

    @Override
    public boolean check(String phoneNum, String vCode) {
        String code = cache.get(phoneNum);
        return code.equals(vCode);
    }

    private String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}
