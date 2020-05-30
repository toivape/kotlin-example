package com.example.weather.temperature

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "weather", url = "\${fmi.apiBase}")
interface FmiClient {

    @GetMapping("/wfs?request=getFeature&storedquery_id=fmi::observations::weather::simple&timestep=60&parameters=t2m&fmisid={fmisid}&starttime={startTime}&endtime={endTime}", consumes = ["application/xml"])
    fun getHourlyTemperatures(
            @PathVariable("fmisid") fmisid: Int,
            @PathVariable("startTime") startTime: String,
            @PathVariable("endTime") endTime: String
    ): String
}
