FROM eclipse-JustJ:23.0.2
WORKDIR workspace

APG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]
