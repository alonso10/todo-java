FROM amazoncorretto:17

WORKDIR /app

COPY . .

RUN ./gradlew build

CMD java -jar build/libs/todo-java-0.0.1-SNAPSHOT.jar0.0.1-SNAPSHOT.jar