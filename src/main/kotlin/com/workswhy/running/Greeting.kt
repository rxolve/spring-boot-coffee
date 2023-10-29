package com.workswhy.running

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "greeting")
class Greeting(private var name: String, private var coffee: String) {
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCoffee(): String {
        return coffee
    }

    fun setCoffee(coffee: String) {
        this.coffee = coffee
    }
}