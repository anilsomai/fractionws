FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fractionws.jar
ENTRYPOINT ["java", "-jar", "fractionws.jar"]