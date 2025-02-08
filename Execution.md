# Employees-R-US - Setup & Testing Guide

## Running the Application

### Formatting Code
To format code according to style guidelines, you can run the **spotlessApply** task:
```sh
./gradlew spotlessApply
```
The Spotless plugin will also execute check-and-validation tasks as part of the Gradle **build** task:
```sh
./gradlew build
```

### Running the Local Server
To start the application on a local server, run:
```sh
./gradlew bootRun
```
When looking at the console output, you should see a message indicating that the application has started successfully you can access the application at:
```localhost:8080/api/v1/employee```
which will return a list of all employees automatically.

## API Endpoints
The application provides the following REST endpoints:

- **GET** `/api/v1/employee` - Retrieve all employees.
- **GET** `/api/v1/employee/uuid={uuid}` - Retrieve an employee by UUID.
- **POST** `/api/v1/employee` - Create a new employee.

### Example: Creating an Employee
You can use Postman to send a **POST** request to create an employee. A Postman collection with example API usage is available at:
```
api/src/test/Employees-R-US.postman_collection.json
```
Once an employee is created, you can retrieve it using the returned UUID.

## Testing
I made an attempt to write a test script located at:
```
api/src/test/java/com/challenge/api/service/EmployeeServiceImplTest.java
```
I am not very familiar with JUnit testing, so I primarily relied on Postman for manual testing. I have never used unit tests in any of my classes before, but I am very interested in learning more about how they work and whether my current approach is on the right track.

## Lessons Learned

Working on *Employees-R-US* provided valuable insights into backend development, API testing, and best practices for maintaining code quality. Here are some key takeaways:

- **Gradle & Spotless**: I learned how to use Gradle for project automation and how Spotless ensures code formatting consistency. Running `spotlessApply` before committing changes helped maintain a clean and readable codebase.
- **Spring Boot & REST APIs**: This project reinforced my understanding of setting up REST endpoints using Spring Boot and handling HTTP requests for CRUD operations. I also gained experience in structuring API routes efficiently.
- **Manual vs. Automated Testing**: While I primarily used Postman for manual testing, I attempted to write unit tests using JUnit. Since I haven't worked with unit tests in my coursework, this was a new challenge, and I am eager to improve my testing skills to ensure more robust code.
- **UUID-Based Entity Retrieval**: Implementing unique identifiers for employees introduced me to UUID-based lookups and how they enhance database integrity compared to traditional incremental IDs.
- **Improving Debugging Skills**: Running `./gradlew bootRun` and monitoring console logs helped me diagnose issues effectively, reinforcing my debugging skills in a real-world application.

Going forward, I plan to deepen my understanding of **JUnit and Mockito** for better test coverage and reliability in backend applications.

---
