package com.example.shell

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

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
		val r= runBlocking {
			val client = HttpClient(CIO)
			val response: HttpResponse = client.get("https://ktor.io/")
			println(response.status)
			println()
			client.close()
			response.bodyAsText()
		}

		return "Hello world ${r}"
	}
}

internal interface RepositoryService {
	@GetExchange("/")
	fun getRepository(
		@PathVariable owner: String?,
		@PathVariable repo: String?
	): String // more HTTP exchange methods...
}
