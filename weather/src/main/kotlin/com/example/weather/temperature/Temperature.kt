package com.example.weather.temperature

import java.io.Serializable

// Class needs to be Serializable for caching to work

class Temperature : Serializable{
    var time: String? = null
    var temperature: String? = null
}
