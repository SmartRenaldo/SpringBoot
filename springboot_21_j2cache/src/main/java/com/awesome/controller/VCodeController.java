package com.awesome.controller;

import com.awesome.domain.VCode;
import com.awesome.service.VCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veri")
public class VCodeController {

    @Autowired
    private VCodeService vCodeService;

    @GetMapping
    public String getCode(String phone){
        String code = vCodeService.sendCode(phone);
        return code;
    }

    @PostMapping
    public boolean checkCode(VCode vCode){
        return vCodeService.checkCode(vCode);
    }


}
