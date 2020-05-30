package com.example.weather.temperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TemperatureServiceTest {

    @Test
    fun `Time is formatted correctly`(){
        val time = LocalDateTime.of(2020,5,29,12,30,0)
        assertEquals("2020-05-29T12:30:00", time.toISO8601())
    }
}