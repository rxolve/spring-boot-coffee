package com.workswhy.running

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class DataLoader(private val coffeeRepository: CoffeeRepository) {
    @PostConstruct
    private fun loadData() {
        coffeeRepository.saveAll(
            listOf(
                Coffee("Latte"),
                Coffee("Mocha"),
                Coffee("Espresso"),
                Coffee("Americano"),
                Coffee("Cappuccino")
            )
        )
    }


}