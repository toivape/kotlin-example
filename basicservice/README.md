
## Basic rest service using Spring-Boot and Kotlin
* CRUD services
* Form validation using annotations
* In-memory sql database
* Integration test using MockMvc and jsonPath
* Swagger integration

### Run application
./mvnw spring-boot:run

### View API using Swagger
http://localhost:8080/swagger-ui.html

### Docker
Pom.xml includes docker build. It requires that Docker desktop is running. Build adds automatically 
tag *latest* to docker image. 

To run application in docker: 
```docker run --name basicservice --rm basicservice```

To stop application in docker:
```docker stop basicservice```

To push image to repo
* You need to login to repo first
* Then run maven command ```mvn dockerfile:push```

As and example login to AWS ECR and push image there while overriding repo and tag defaults in pom.xml:
```
$(aws ecr get-login --no-include-email --region eu-west-1)
./mvnw dockerfile:push -Ddockertag=$IMAGE_TAG -Ddockerrepo=$REPO_URL
```