package com.ace.htmxrouter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
    PageService pageService;
    @GetMapping()
    public String main(Model model){
        pageService.loadMainDate(model);
        model.addAttribute("fragment","/page/main");
        return "index";
    }
    @GetMapping("/about")
    public String about(Model model){
        pageService.loadMainDate(model);
        model.addAttribute("fragment","/page/about");
        return "index";
    }
}
