# Developer for a Day

Code base and supplementary material for the "Developer for a Day" event held at NTT DATA.

## Goal

The attendees of this workshop will gain first experience as cloud-native developers by extending the implementation of three existing microservices.
Both backend microservices "weather-station" and "weather-map" are implemented in Java using the Quarkus framework.
The frontend microservice "weather-ui" is implemented in Typescript using the Angular framework.

## Tasks

* Backend -> _weather station microservice_

    In the StationResource, implement POST and DELETE REST API endpoints to put a new record into the database, to delete a record by name and to delete all records.

* Frontend

    Integrate the POST and DELETE REST API endpoints from the backend and call them upon user interaction. Implement a delete modal to ask the user to confirm the requested delete operation before it is executed.

* Backend -> _weather map microservice_

    In the WeatherStationApi, complete the implementation of the REST API client. Inject it into the WeatherCollector to construct a WeatherMap with the data obtained from the weather stations.

* Frontend

    Replace the multiple GET REST API calls to the weather station with a single GET REST API call to the weather map.

* Backend -> _weather map microservice_

    In the WeatherMapResource, add temperatureUnit as a request parameter and pass it to the WeatherCollector. In the WeatherCollector, implement methods to convert the temperature attribute of the WeatherData object obtained from the weather station between Celsius and Fahrenheit as requested.

All user stories can be found in the [product backlog](https://miro.com/app/board/uXjVO552lL4=/?share_link_id=328956951672) on Miro. The board password is `weAREgreat!`

## Supplementary Material

* `developer-for-a-day.pptx` -> the introductory presentation

* `Makefile` -> a collection of useful commands to start the backend microservices on localhost in DEV mode or as Docker containers 

* `developer-for-a-day.postman_collection.json` -> a Postman collection of REST API requests to test your implementation

## Installation Guidelines

* IDE - recommended are [IntelliJ](https://www.jetbrains.com/idea/download/) or [VS Code](https://code.visualstudio.com/Download/)

* [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

* [NodeJS](https://nodejs.org/en/download/) (latest LTS vesion)

* [Docker Desktop](https://docs.docker.com/desktop/)

    If you work under Windows, make sure the box "Use the WSL 2 based engine" under Settings > General is checked.

* [Maven](https://maven.apache.org/install.html)

    Follow the instructions to set the environment variables `JAVA_HOME` and `MAVEN_HOME`. Do not forget to also add `%JAVA_HOME%\bin` and `%MAVEN_HOME%\bin` to the PATH environment variable.

* [Postman](https://www.postman.com/downloads/)