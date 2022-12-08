# SEG3102 Project Repository - Team 3

**Branch deliverable**: Deliverable 2 *(Domain)*

Project JDK: 19 (19.0.1; vendor: Oracle OpenJDK)<br>
Language Level: 17<br>
Gradle JVM: 17 (17.0.5; vendor: corretto)<br>

**Team members**:
* 300250180 - Fahmi Ahmed
* 300164095 - Axel Tang
* 300078744 - Mustafa Sarikaya
* 300256085 - Daniel Kinsey
* 300132984 - Guillaume Labasse

**As with many other teams, our entire system (including every planned use-case/functionality) could not be finished in time. Basic navigation and authentication/authorization works, and many necessary components for our infrasttructure were partly or fully finished, but finishing everything proved an impossible, herculean task (see video presentation for why). Nevertheless, you will see in our commit history that we *did* put in an absolute ton of work for this deliverable. We thank you for your understanding.**

## How to build

We did our best to provide the building options expected by the teacher.

### Building with compose

```docker compose up -d --build```

... will successfully build and run our application and MongoDB, but the application unexpectedly crashes without giving us a log to debug. We could not find any other examples of `docker compose` with Spring and MongoDB that wouldn't result in this behavior. Our apologies for the inconvenience. 

### Building (traditional)

1. Install Docker Desktop.
2. Run `docker run -p 27017:27017 --name mongodb -d mongo` in the project root to set up a MongoDB container for the application.
3. With docker running, run the Gradle build file, either through an IDE or via `./gradlew bootRun`.

Once the application server is up, navigate to: http://localhost:9000/
