package com.ace.htmxrouter;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.Map;

@Service
public class PageService {

    public void stuff(){}

    public String openPage(Page page, Model model, boolean fragment, Map<String, String> allRequestParams) {
        model.addAttribute("time", new Date());
        model.addAttribute("name","coucou");
        return page.fragmentPath;
    }
}
