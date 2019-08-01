package com.johnowl.owlconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class OwlConfigServerApplication

fun main(args: Array<String>) {
	runApplication<OwlConfigServerApplication>(*args)
}