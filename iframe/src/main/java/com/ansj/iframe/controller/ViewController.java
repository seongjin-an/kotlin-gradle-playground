package com.ansj.iframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class ViewController {
    @GetMapping
    public String index() {
        return "hello";
    }

    @GetMapping("ohayo")
    public String ohayo() {
        return "ohayo";
    }
}
