FROM openjdk:17-jdk-alpine3.13

COPY /build/libs /app
WORKDIR /app

ENTRYPOINT ["java", "-jar", "iuppsample-0.1-all.jar"]
