# PhrmacyStore Project Repository

Project JDK: 19 (19.0.1; vendor: Oracle OpenJDK)<br>
Language Level: 17<br>
Gradle JVM: 17 (17.0.5; vendor: corretto)<br>

**Team members**:
*  Daniel Kinsey
*  Guillaume Labasse
*  Mustafa Sarikaya
*  Fahmi Ahmed
*  Axel Tang

### Building with compose

```docker compose up -d --build```

... will successfully build and run our application and MongoDB, but the application unexpectedly crashes without giving us a log to debug. We could not find any other examples of `docker compose` with Spring and MongoDB that wouldn't result in this behavior. Our apologies for the inconvenience. 

### Building (traditional)

1. Install Docker Desktop.
2. Run `docker run -p 27017:27017 --name mongodb -d mongo` in the project root to set up a MongoDB container for the application.
3. With docker running, run the Gradle build file, either through an IDE or via `./gradlew bootRun`.

Once the application server is up, navigate to: http://localhost:9000/
