package com.example.weather.temperature

import org.xml.sax.Attributes
import org.xml.sax.InputSource
import org.xml.sax.helpers.DefaultHandler
import java.io.StringReader
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

fun parseTemperatureXml(xml: String): List<Temperature> {
    val factory = SAXParserFactory.newInstance()
    val saxParser: SAXParser = factory.newSAXParser()

    val saxHandler = TemperatureSAXHandler()
    val inputSource = InputSource(StringReader(xml))
    saxParser.parse(inputSource, saxHandler)

    return saxHandler.temperatures
}

class TemperatureSAXHandler : DefaultHandler() {

    val temperatures = mutableListOf<Temperature>()

    var elementValue: String? = null

    override fun startElement(uri: String, localName: String, qName: String, attributes: Attributes) {
        if (qName == WFS_MEMBER) {
            temperatures.add(Temperature())
        }
    }

    override fun characters(ch: CharArray, start: Int, length: Int) {
        elementValue = String(ch, start, length)
    }

    override fun endElement(uri: String, localName: String, qName: String) {
        if (qName == BS_WFS_TIME) {
            temperatures.last().time = elementValue
        } else if (qName == BS_WFS_PARAMETER_VALUE) {
            temperatures.last().temperature = elementValue
        }
    }

    companion object {
        private const val WFS_MEMBER = "wfs:member"
        private const val BS_WFS_TIME = "BsWfs:Time"
        private const val BS_WFS_PARAMETER_VALUE = "BsWfs:ParameterValue"
    }
}