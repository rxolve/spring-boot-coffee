package com.workswhy.running

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
class Coffee(private var name: String) {
    @Id
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
