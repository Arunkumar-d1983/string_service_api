# Rewards API

### Project Overview
REST API to remove first and last characters from a string

#### Clone the Repository
``` git clone https://github.com/Arunkumar-d1983/string_service_api ```

``` git branch ```
``` master ``` 

#### Prerequisites:

- Ensure that JDK 1.8 or higher is installed on your machine.If Java is not installed or the version is lower than 1.8, you need to install JDK 1.8 
    * Visit the Oracle JDK download page: [Oracle JDK Download](https://www.oracle.com/java/technologies/downloads/#java8).
    * After the installation is complete, verify the Java version again using the `java -version` command to ensure that JDK 1.8
- Verify that you have Apache Maven installed. You can check by running `mvn -version` in your command line.
- Install Postman or any other API testing tool.

#### Technology Stack
| Tool               | Version                 |
| ------------------ | ----------------------- |
| Java               | 8                       |
| Spring Boot        | 2.7.0                   |
| Maven              | Build Tool              |
| JUnit              | Testing                 |



#### Build the application:

- Open a command and navigate to the root directory of the mbean application project.
- Run the following command to build the application.
  
Build and Run :
```
mvn spring-boot:run
```
(OR)

```
mvn clean package

After the build is successful and the JAR file is generated, navigate to the target
directory and run the following command to execute it.

java -jar customer-rewards-api-0.0.1-SNAPSHOT
```

#### Run All Tests
To verify that the application works correctly and passes all tests, run:
``` 
mvn verify
```
## API Endpoint
###  GET /api

Description: Calculates reward points for a given customer.

### Example Request:
``` GET http://localhost:8080/api/remove?input=country ```

### Sample Response :
```json
{
    "input": "country",
    "result": "ountr"
}
```

### Example Request:
``` http://localhost:8080/api/remove?input=ab ```

### Sample Response :
```json
{
    "input": "ab",
    "result": ""
}
```

### Example Request:
``` http://localhost:8080/api/remove?input=a ```

### Sample Response :
```json
{
    "error": "Input must be at least 2 characters."
}
```
### Example Request:
``` http://localhost:8080/api/remove?input=*123*%qwerty+ ```

### Sample Response :
```json
{
    "input": "*123*%qwerty+",
    "result": "123*%qwerty"
}
```
