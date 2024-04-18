package com.ace.observ;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MachinController {

    @GetMapping("/hello")
    public String machin() {
        return "coucou";
    }
}
