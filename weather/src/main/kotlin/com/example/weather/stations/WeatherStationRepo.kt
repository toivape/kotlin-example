package com.example.weather.stations

import org.springframework.data.jpa.repository.JpaRepository

// Requires @EnableJpaRepositories annotation in Application config
interface WeatherStationRepo : JpaRepository<WeatherStation, Int> {
    fun findAllByOrderByNameAsc(): List<WeatherStation>
}