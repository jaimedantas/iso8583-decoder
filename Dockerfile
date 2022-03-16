# Maven
FROM maven:3.8.1-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean -e -B package

# RTSDK Java

FROM openjdk:11-jre-slim-buster
WORKDIR /app
COPY --from=builder /app/target/iso8583-decoder-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","./iso8583-decoder-0.0.1-SNAPSHOT.jar"]
CMD ["-ric","/EUR="]
