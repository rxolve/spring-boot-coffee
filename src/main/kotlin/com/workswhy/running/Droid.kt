package com.workswhy.running

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "droid")
class Droid(
    private var id: String = "",
    private var description: String = ""
) {
    fun getId(): String {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }
}