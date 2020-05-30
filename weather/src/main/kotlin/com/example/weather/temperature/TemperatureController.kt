package com.example.weather.temperature

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TemperatureController(private val temperatureService: TemperatureService) {

    @GetMapping("/api/v1/temperature24h/{fmisid}")
    fun getTemperaturesLast24Hours(@PathVariable("fmisid") fmisid: Int): List<Temperature> = temperatureService.getTemperaturesLast24Hours(fmisid)

}