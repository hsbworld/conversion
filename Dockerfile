FROM eclipse-temurin:17

WORKDIR /app

COPY /target/conversion-0.0.1-SNAPSHOT.jar /app/conversion-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "conversion-0.0.1-SNAPSHOT.jar"]
