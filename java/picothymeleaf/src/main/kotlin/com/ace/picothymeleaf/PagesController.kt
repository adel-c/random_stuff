package com.ace.picothymeleaf

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("page")
class PagesController(val pageService: PageService) {

    @GetMapping("/main")
    fun main(model: Model):String{
        pageService.loadMainDate(model)
        return "/page/main"
    }
    @GetMapping("/about")
    fun about(model: Model):String{
        pageService.loadMainDate(model)
        return "/page/about"
    }
}
