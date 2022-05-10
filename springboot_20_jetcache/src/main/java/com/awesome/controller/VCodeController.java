package com.awesome.controller;

import com.awesome.domain.VCode;
import com.awesome.service.VCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/vcode")
public class VCodeController {

    @Autowired
    private VCodeService vCodeService;

    @GetMapping
    public String getCode(String phone) {
        return vCodeService.sendCode(phone);
    }

    @PostMapping
    public boolean check(VCode vCode) {
        return vCodeService.check(vCode);
    }
}
