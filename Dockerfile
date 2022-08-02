FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fractionws.jar
ENTRYPOINT ["java", "-jar", "fractionws.jar"]