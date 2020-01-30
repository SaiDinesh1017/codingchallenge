# Spring Boot Project

### Project Description
This project provide an algorithm that produces the minimum number of ranges required to represent the same restrictions 
as the input for a given collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds) .

### Technologies Used
* Spring boot 1.5
* Java 1.8, REST webservice
* Junit4, Mockito
* Swagger for API documentation
* Jacoco for code coverage metrics
* Gradle 3.5
* Embeded Tomcat

### Assumptions
* For each range of zip code includes both their upper and lower bounds, the lower bound must be less than the upper bound.

### Validations
* Zip code must be 5 digits
* the lower bound of the zip code range must be less than the upper bound.

### To build the project 
```
./gradlew clean build
```
**jar**  _codingchallenge-2.0.0-SNAPSHOT.jar will be created_

### To run test cases and obtain the test coverage report of the project
```
./gradlew clean build jacocoTestReport 
```
_open index.html in browser from the path ~/codingchallenge/build/jacocoHtml/index.html_

### To obtain the bugs report over the project
``` 
./gradlew clean build
```
_open main.html in browser from the path ~/codingchallenge/build/reports/findbugs/main.html_

### Steps to run the project
#### Step 1
```
git clone https://github.com/SaiDinesh1017/codingchallenge.git 
```
#### Step 2
```
./gradlew bootRun
``` 

### To test the project
* After running the project as described above. Go to --> [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)
* http://localhost:8080/swagger-ui.html#/zip-range-controller/zipRangesUsingPOST
* By using the zip range controller from swagger ui we can test the code with possible scenarios
