package com.example.weather.stations

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "weather_station")
data class WeatherStation(
        @Id
        val fmisid: Int,
        val name: String,
        val lpnn: Int?,
        val wmo: Int?,
        val lat: BigDecimal,
        val lng: BigDecimal,
        val height: Int,
        val type: String,
        val since: Int
)