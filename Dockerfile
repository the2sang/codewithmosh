FROM eclipse-temurin:17 AS builder
WORKDIR workspace

COPY target/*.jar catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]

RUN java -Djarmode=layertools -jar catalog-service.jar extract

FROM eclipse-temurin:17
RUN useradd spring
USER spring
WORKDIR workspace
COPY --from=builder workspace/dependencies/ ./
COPY --from=builder workspace/spring-boot-loader/ ./
COPY --from=builder workspace/snapshot-dependencies/ ./
COPY --from=builder workspace/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]