package com.rest.practiceapp.generators

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TweetIdGenerator {

    var createdAt:String

    init {
        createdAt = ""
    }

    fun generate():String{
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSS")
        val current = LocalDateTime.now()
        createdAt = current.toString()

        val formatted = current.format(formatter)

        val yy = formatted.substring(0, 4)
        val mm = formatted.substring(4, 6)
        val dd = formatted.substring(6, 8)

        val hh = formatted.substring(12, 14)
        val ss = formatted.substring(15, 17)

        return hh + yy + dd + ss + mm
    }
}