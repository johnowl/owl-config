package com.johnowl.owlconfigclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OwlConfigClientApplication

fun main(args: Array<String>) {
	runApplication<OwlConfigClientApplication>(*args)
}
