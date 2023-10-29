package com.workswhy.running

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {
    @PostMapping("")
    fun create(@RequestBody coffee: Coffee): Coffee {
        coffeeRepository.save(coffee)
        return coffee
    }

    @GetMapping("")
    fun all(): List<Coffee> {
        return coffeeRepository.findAll().toList()
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: String): Coffee? {
        return coffeeRepository.findById(id).orElse(null)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee>? {
        return coffeeRepository.existsById(id).let {
            if (it) {
                coffeeRepository.save(coffee)
                return ResponseEntity(coffee, HttpStatus.OK)
            } else {
                coffeeRepository.save(coffee)
                return ResponseEntity(coffee, HttpStatus.CREATED)
            }
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<String> {
        coffeeRepository.deleteById(id)
        return ResponseEntity("OK", HttpStatus.OK)
    }
}