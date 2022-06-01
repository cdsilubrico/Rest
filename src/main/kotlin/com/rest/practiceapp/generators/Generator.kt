package com.rest.practiceapp.generators

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Generator {

    fun generateID(): String {

        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSS")
        val current = LocalDateTime.now()

        val formatted = current.format(formatter)
        println(formatted)

        val yy = formatted.substring(0, 4)
        val mm = formatted.substring(4, 6)
        val dd = formatted.substring(6, 8)

        val hh = formatted.substring(12, 14)
        val ss = formatted.substring(15, 17)

        return hh + yy + dd + ss + mm
    }
}