# CourseKtorServer
This application is a Ktor-based server that provides a REST API for managing course information. 
It can be used to communicate with an Android application via API calls, but it can also be used to display information directly in a web browser. 
The application only runs on a local network, making it accessible mainly from devices connected to the same network.

## Main features

Top race retrieval:

- Endpoint: GET /course/top : This route returns information on the course with the highest level.

Course retrieval by ID:

- Endpoint: GET /course/{id} : This route returns details of a specific course according to its ID.

## Technology

- Ktor: Kotlin framework for creating robust, high-performance server applications.
- Kotlinx.serialization: Used to serialize Kotlin objects to JSON, facilitating communication with Android clients and the browser.
- API Routes: Each route responds to HTTP (GET) requests and returns either model data in JSON, or a 404 error message if no data is available.

## Communication

- API calls: The server application is designed to interact with an Android application, which can make network calls to retrieve and display course information.
- Browser display: You can also access information via a browser by sending requests to the same endpoints, making the application versatile.

## Network context

- Local only: The application is hosted locally (on 127.0.0.1:8080) and can only be accessed via the local network. Clients on an Android emulator can access it using the 10.0.2.2 alias.

## Error handling

- If no data is found, the server returns an HTTP 404 error code with a clear error message.