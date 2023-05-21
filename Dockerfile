# First stage: build with Maven Builder
FROM openjdk:17-jdk-slim as builder
COPY target/twitter-clone-0.0.1-SNAPSHOT.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Second stage: production stage
FROM openjdk:17-jdk-slim
COPY --from=builder ./dependencies/ ./
COPY --from=builder ./spring-boot-loader/ ./
COPY --from=builder ./snapshot-dependencies/ ./
COPY --from=builder ./application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]