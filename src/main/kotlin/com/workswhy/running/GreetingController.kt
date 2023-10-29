package com.workswhy.running

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(
    private var greeting: Greeting
) {
    @GetMapping("")
    fun getName(): String {
        return greeting.getName()
    }

    @GetMapping("/coffee")
    fun getCoffee(): String {
        return greeting.getCoffee()
    }
}