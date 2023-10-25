package com.workswhy.running

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
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
    private var coffees = mutableListOf(
        Coffee("Kaldi's Coffee"),
        Coffee("Espresso"),
        Coffee("Latte"),
        Coffee("Cappuccino")
    )

    @PostMapping("")
    fun create(@RequestBody coffee: Coffee): Coffee {
        coffees += coffee
        return coffee
    }

    @GetMapping("")
    fun all(): List<Coffee> {
        return coffees
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: String): Coffee? {
        return coffees.firstOrNull { coffee: Coffee -> coffee.getId() == id }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee>? {
        val isExist = coffees.any { coffee: Coffee -> coffee.getId() == id }
        println("isExist: $isExist")
        if (!isExist) {
            coffees += coffee

            return ResponseEntity(coffee, HttpStatus.CREATED)
        }
        coffees
            .filter { coffee: Coffee -> coffee.getId() == id }
            .map { coffee: Coffee ->
                coffee.setName(coffee.getName())
                coffee
            }
            .firstOrNull()

        return ResponseEntity(coffee, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Coffee? {
        return coffees
            .filter { coffee: Coffee -> coffee.getId() == id }
            .map { coffee: Coffee ->
                coffees.remove(coffee)
                coffee
            }
            .firstOrNull()
    }
}