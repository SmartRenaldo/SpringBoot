package com.awesome.controller;

import com.awesome.controller.utils.R;
import com.awesome.domain.Book;
import com.awesome.service.IBookService;
import com.awesome.service.TxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
// realise interaction between front-end and back-end
@CrossOrigin
@RequestMapping("/txt")
public class TxtController {

    @Autowired
    private TxtService txtService;

    @PostMapping
    public boolean check(String phoneNum, String vCode) {
        return txtService.check(phoneNum, vCode);
    }

    @GetMapping("/{phoneNum}")
    public String getById(@PathVariable String phoneNum) {
        return txtService.get(phoneNum);
    }

}
