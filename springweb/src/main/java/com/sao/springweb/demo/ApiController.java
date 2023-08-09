package com.sao.springweb.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author saozd
 * @project com.sao.springweb.demo courseexample
 * 20.06.2023 Haz 2023
 */
@RestController
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "Merhaba Spring Dünyası";
    }
}
