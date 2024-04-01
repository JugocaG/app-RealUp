FROM eclipse-temurin:17.0.9_9-jdk
ADD build/libs/RealUpCotizador-0.0.1-SNAPSHOT.jar RealUpCotizador-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "RealUpCotizador-0.0.1-SNAPSHOT.jar"]

