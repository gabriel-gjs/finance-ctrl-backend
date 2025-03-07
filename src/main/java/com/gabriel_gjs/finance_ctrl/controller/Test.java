package com.gabriel_gjs.finance_ctrl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/teste")
@RestController
public class Test {

    @GetMapping
    public String test () {
        return "teste";
    }
}
