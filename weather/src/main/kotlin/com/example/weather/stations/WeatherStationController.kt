package com.example.weather.stations

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/weatherstation")
class WeatherStationController(private val weatherStations: WeatherStationRepo) {

    @GetMapping
    fun getWeatherStations(): List<WeatherStation> = weatherStations.findAllByOrderByNameAsc()
}