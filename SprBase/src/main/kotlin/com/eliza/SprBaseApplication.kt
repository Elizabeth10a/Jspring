package com.eliza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SprBaseApplication

fun main(args: Array<String>) {
    runApplication<SprBaseApplication>(*args)
}
