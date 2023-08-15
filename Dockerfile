FROM openjdk:17-jdk-alpine

RUN apk update && apk add --no-cache bash gradle

WORKDIR /app

COPY . .

RUN gradle build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/todo-java-0.0.1-SNAPSHOT.jar"]