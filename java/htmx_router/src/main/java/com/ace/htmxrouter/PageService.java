package com.ace.htmxrouter;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;

@Service
public class PageService {

    public void stuff(){}

    public void loadMainDate(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("name","coucou");
    }
}
