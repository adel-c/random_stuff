package com.ace.picothymeleaf

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*


@Controller
@RequestMapping("/")
class MachinController(val pageService: PageService)  {
    @GetMapping
    fun machin(model: Model): String {
        pageService.loadMainDate(model)
        return "index"
    }

    @GetMapping("/c/2")
    fun p2(model: Model): String {
        model.addAttribute("testAtt", Date())
        return "deuxiemepage"
    }

    @GetMapping("/c/3")
    @ResponseBody
    fun p3(): String {

        return "c'est pas une page"
    }
}
