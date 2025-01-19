FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/user-profile-service.jar user-profile-service.jar
ENTRYPOINT ["java", "-jar", "/user-profile-service.jar"]