#Build stage (optional if you build jar on host: here we copy the jar only)
FROM eclipse-temurin:21jre AS runtime
WORKDIR /app

#Copy the fat jar built by Maven (see step 6)
COPY target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]