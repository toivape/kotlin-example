# Weather
Get temperature data from FMI (Finnish Meteorological Institute) based on weather measuring station.

* Parse XML formatted weather data and expose it as JSON
* Run Postgres as docker container
* Use Flyway to create and initialize the database
* Cache requests to FMI
* Use OpenFeign to make requests to FMI API

### To run

Requires Java 11.

Before starting the application you need to start Postgres database. Run script:
```./pg_start.sh```
It will start Postgres as a docker container. There is also script pg_stop.sh to stop the container.

Start application using maven:
````mvn spring-boot:run````

Get list of available weather stations: http://localhost:8080/api/v1/weatherstation

Get temperatures for the weather station: http://localhost:8080/api/v1/temperature24h/101003



