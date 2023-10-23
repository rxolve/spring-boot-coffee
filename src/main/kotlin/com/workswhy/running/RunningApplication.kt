package com.workswhy.running

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@SpringBootApplication
class RunningApplication

fun main(args: Array<String>) {
    runApplication<RunningApplication>(*args)
}

class Coffee(private var name: String) {
    private val id: String = UUID.randomUUID().toString()

    fun getId(): String {
        return id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }
}

@RestController
@RequestMapping("/coffees")
class CoffeeController {
    private var coffees = listOf<Coffee>(
        Coffee("Americano"),
        Coffee("Latte"),
        Coffee("Mocha")
    )

    @GetMapping("")
    fun all(): List<Coffee> {
        return coffees
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: String): Coffee? {
        println("id1: $id")
        return coffees.stream()
            .filter { c: Coffee -> c.getId() == id }
            .findFirst()
            .orElse(null)
    }
}