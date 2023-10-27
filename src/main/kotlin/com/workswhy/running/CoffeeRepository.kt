package com.workswhy.running

import org.springframework.data.repository.CrudRepository

interface CoffeeRepository : CrudRepository<Coffee, String> {
}
