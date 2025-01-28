package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class Ex19CalcController {

    @RequestMapping("")
    public String index(int num1, int num2){
       int result = num1 + num2;
        return "/calc/ex-19-calc-result";
    }

}
