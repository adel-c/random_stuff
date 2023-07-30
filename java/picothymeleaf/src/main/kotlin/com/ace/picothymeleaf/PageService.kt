package com.ace.picothymeleaf

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import java.util.*

@Service
class PageService {

fun loadMainDate(model: Model){
    model.addAttribute("time", Date())
    model.addAttribute("name","coucou")
}
}
