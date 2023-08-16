FROM amazoncorretto:17

WORKDIR /app

COPY . .

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/my-app-0.0.1-SNAPSHOT.jar"]