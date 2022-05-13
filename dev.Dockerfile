############
# builder
############
FROM maven:3.6.3-amazoncorretto-11 AS builder

WORKDIR /opt/nmrc-api-build

COPY src/ ./src
COPY pom.xml .

RUN mvn package -Pdev -DskipTests=true

############
# application
############
FROM maven:3.6.3-amazoncorretto-11

WORKDIR /opt/nmrc-api

ENV TZ=Asia/Tokyo

COPY --from=builder /opt/nmrc-api-build/target/nomurec-1.0.jar .
COPY --from=builder /opt/nmrc-api-build/src/main/resources/ ./src/main/resources
COPY --from=builder /opt/nmrc-api-build/pom.xml .
COPY scripts/ ./scripts

# Download flyway-plugin
RUN mvn -Dflyway.configFiles=src/main/resources/application-dev.properties flyway:info; exit 0

EXPOSE 8080

ENTRYPOINT ["scripts/entrypoint_dev.sh"]
