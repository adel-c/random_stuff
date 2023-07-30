package com.ace.picothymeleaf

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
@RequestMapping("/api")
class ApiController {
    @GetMapping("/clicked")
    @ResponseBody
    fun machin2(): String {
        val persons: List<Person> = listOf(Person(UUID.randomUUID().toString(), 33), Person("p2", 22))

        val message = buildString {
            appendHTML().table {
                thead {
                    tr {
                        th { text("r1") }
                        th { text("r2") }
                    }
                }
                tbody {
                    personsRows(persons)
                }
            }
        }
        println(message)

        return message
    }

    private fun TBODY.personsRows(persons: List<Person>) {
        persons.map { p ->
            tr {
                td { text(p.name) }
                td { text(p.age) }
            }
        }
    }


    @GetMapping("/clicked2")

    fun machin(model: Model): String {
        model.addAttribute("time", Date())
        model.addAttribute("name", "coucou")
    val persons: List<Person> = listOf(Person(UUID.randomUUID().toString(), 33), Person("p2", 22))

    model.addAttribute("persons", persons)

        return "api/dostuff"
    }

    fun TABLE.apply(p: List<Person>): String {
        return "aze"
    }

    data class Person(val name: String, val age: Int)
}
