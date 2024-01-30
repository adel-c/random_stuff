package com.example.shell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@SpringBootApplication
class ShellApplication

fun main(args: Array<String>) {
	runApplication<ShellApplication>(*args)
}


@ShellComponent
class MyCommands {
	@ShellMethod(key = ["hello-world"])
	fun helloWorld(
		@ShellOption(defaultValue = "spring") arg: String
	): String {
		return "Hello world $arg"
	}
}
