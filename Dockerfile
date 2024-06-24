FROM openjdk:21-jdk
ADD target/app.jar assemblyinterpreter.jar
ENTRYPOINT ["java", "-jar", "/assemblyinterpreter.jar"]