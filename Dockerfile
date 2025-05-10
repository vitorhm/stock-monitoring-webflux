FROM eclipse-temurin:21

COPY ./ /app

WORKDIR app

RUN ./gradlew build

ENTRYPOINT ["java", "-jar", "build/libs/stock-monitoring-1.0-SNAPSHOT.jar"]