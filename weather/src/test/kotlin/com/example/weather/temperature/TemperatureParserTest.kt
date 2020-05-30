package com.example.weather.temperature

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemperatureParserTest {

    @Test
    fun `Parse temperature query response XML to temperature list`(){
        val temperatures = parseTemperatureXml(TEMPERATURE_XML)
        assertThat(temperatures).size().isEqualTo(24)
        assertEquals("12.1", temperatures.first().temperature)
        assertEquals("2020-05-29T08:00:00Z", temperatures.first().time)
        assertEquals("12.9", temperatures.last().temperature)
        assertEquals("2020-05-30T07:00:00Z", temperatures.last().time)
    }

    companion object{
        const val TEMPERATURE_XML =
"""<?xml version="1.0" encoding="UTF-8"?>
<wfs:FeatureCollection
  timeStamp="2020-05-30T07:38:26Z"
  numberReturned="24"
  numberMatched="24"
      xmlns:wfs="http://www.opengis.net/wfs/2.0"
    xmlns:gml="http://www.opengis.net/gml/3.2"
    xmlns:BsWfs="http://xml.fmi.fi/schema/wfs/2.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.opengis.net/wfs/2.0 http://schemas.opengis.net/wfs/2.0/wfs.xsd
                        http://xml.fmi.fi/schema/wfs/2.0 http://xml.fmi.fi/schema/wfs/2.0/fmi_wfs_simplefeature.xsd"
>
  	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.1.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.1.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T08:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.1</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.2.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.2.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T09:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.9</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.3.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.3.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T10:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.2</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.4.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.4.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T11:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.7</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.5.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.5.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T12:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.1</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.6.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.6.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T13:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.5</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.7.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.7.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T14:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.3</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.8.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.8.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T15:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.5</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.9.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.9.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T16:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>13.9</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.10.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.10.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T17:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>14.5</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.11.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.11.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T18:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>15.1</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.12.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.12.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T19:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>14.4</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.13.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.13.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T20:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>14.7</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.14.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.14.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T21:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>14.1</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.15.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.15.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T22:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>13.9</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.16.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.16.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-29T23:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.2</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.17.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.17.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T00:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.0</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.18.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.18.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T01:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.5</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.19.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.19.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T02:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.6</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.20.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.20.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T03:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.7</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.21.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.21.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T04:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.8</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.22.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.22.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T05:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>11.7</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.23.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.23.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T06:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.1</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	
	<wfs:member>
            <BsWfs:BsWfsElement gml:id="BsWfsElement.1.24.1">
                <BsWfs:Location>
                    <gml:Point gml:id="BsWfsElementP.1.24.1" srsDimension="2" srsName="http://www.opengis.net/def/crs/EPSG/0/4258">
                        <gml:pos>59.94898 24.92631 </gml:pos>
                    </gml:Point>
                </BsWfs:Location>
                <BsWfs:Time>2020-05-30T07:00:00Z</BsWfs:Time>
                <BsWfs:ParameterName>t2m</BsWfs:ParameterName>
                <BsWfs:ParameterValue>12.9</BsWfs:ParameterValue>
            </BsWfs:BsWfsElement>
	</wfs:member>
	

</wfs:FeatureCollection>            
"""
    }
}