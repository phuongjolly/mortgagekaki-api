FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD target/loan-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar", "--spring.profiles.active=production"]