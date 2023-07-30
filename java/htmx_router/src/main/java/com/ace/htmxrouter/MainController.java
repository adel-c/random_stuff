package com.ace.htmxrouter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @GetMapping("page/{pageRef}")
    public String mainPage(Model model, @PathVariable("pageRef")String pageRef, @RequestHeader(value = "page-fragment",required = false,defaultValue = "false")String fragmentOnlyHeader){
        boolean fragment = "true".equalsIgnoreCase(fragmentOnlyHeader);
        String templateFragment="/page/"+pageRef;
        model.addAttribute("fragment",templateFragment);
        pageService.loadMainDate(model);
        if(fragment){
            return templateFragment;
        }

        return "index";
    }

}
