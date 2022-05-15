# springboot-chat

This repository contains the Springboot REST API for a simple application that allows 2 users communicate with each other in plain text.

## Running the backend

On a console terminal navigate into the `chat` folder and run the following:

```
./mvnw spring-boot:run 
```

The services are accessible through the url `http://localhost:8080/api/` it will ask for a login with username `user` and the auto generated password, this is mostly due to time constraints I wasn't able to fully implement an oauth based security so it's using the default one. That will also describe the available APIs mostly one being a simple CRUD for users that will use the messaging features and one custom API for the actual messages in the app.

To package a jar with the api run:

```
./mvnw clean package
```


## Technologies applied

In this one I'm using JPA to persist in memory (H2) the chat data. On a real world scenario, the JPA would persist the data on an external database or a similar datastore that won't be on the same server/instance/container as this API, this would allow us have more flexibility when running this application on different servers this will be explained further in the following section.

## Application's scaling

The application can scale easily by having a middle proxy microservice that would forward the request to specific containers/servers/instances using a consistent hashing algorithm to determine which one would be the one in charge of resolving the request. The backend can be exported to an easy to execute jar like normally and then deployed to any container or even with docker as detailed in [this guide](https://spring.io/blog/2018/11/08/spring-boot-in-a-container)


## Other solutions

For this kind of application, I'd use a websocket connection implementing STOMP(Simple Text Oriented Messaging Protocol) to get instant notifications of incoming messages converting the application into something more instant.
