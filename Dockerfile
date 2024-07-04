FROM openjdk:21-jdk
WORKDIR /app
ADD target/app.jar app/assemblyinterpreter.jar
ENTRYPOINT ["java", "-jar", "app/assemblyinterpreter.jar"]