package com.example.weather.temperature

import com.example.weather.stations.WeatherStationRepo
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

// FMI uses UTC time to store measurement data. Convert local time to UTC.
private val TZ_UTC: ZoneId = ZoneId.of("UTC")
fun LocalDateTime.toUTC(): LocalDateTime = this.atZone(ZoneId.systemDefault()).withZoneSameInstant(TZ_UTC).toLocalDateTime()

// Format time as is required by FMI API
private val ISO8601_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
fun LocalDateTime.toISO8601(): String = this.format(ISO8601_FORMAT)

private val logger = KotlinLogging.logger {}

@Service
class TemperatureService(private val fmiClient: FmiClient, private val weatherStations: WeatherStationRepo) {

    @Cacheable(value = ["temperature24h"], key = "#fmisid")
    fun getTemperaturesLast24Hours(fmisid: Int): List<Temperature> {
        if (!isValidWeatherStation(fmisid)){
            logger.info { "Unknown weather station [$fmisid]" }
            return emptyList()
        }
        logger.info { "Get temperatures for fmisid [$fmisid]" }
        val resultXml = fmiClient.getHourlyTemperatures(fmisid, get24HoursAgo(), getNow())
        return parseTemperatureXml(resultXml)
    }

    private fun isValidWeatherStation(fmisid:Int):Boolean = weatherStations.findById(fmisid).isPresent

    private fun getNow(): String = LocalDateTime.now().toUTC().toISO8601()

    private fun get24HoursAgo(): String = LocalDateTime.now().minusDays(1).toUTC().toISO8601()
}