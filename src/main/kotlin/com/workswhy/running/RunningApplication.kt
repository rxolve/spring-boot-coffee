package com.workswhy.running

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class RunningApplication

fun main(args: Array<String>) {
    runApplication<RunningApplication>(*args)
}
