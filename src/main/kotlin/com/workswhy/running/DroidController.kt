package com.workswhy.running

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/droid")
class DroidController(private val droid: Droid) {
    @RequestMapping("")
    fun getDrone(): Droid {
        return droid
    }

}