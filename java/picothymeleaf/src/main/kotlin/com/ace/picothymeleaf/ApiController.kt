package com.ace.picothymeleaf

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@Controller
@RequestMapping("/api")
class ApiController {
    @GetMapping("/clicked")
    fun machin(model: Model): String {
        model.addAttribute("time", Date())
        model.addAttribute("name", "coucou")
        model.addAttribute("persons", listOf(Person(UUID.randomUUID().toString(), 33), Person("p2", 22)))
        return "api/dostuff"
    }

    data class Person(val name: String, val age: Int)
}
