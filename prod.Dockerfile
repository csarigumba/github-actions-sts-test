############
# builder
############
FROM maven:3.6.3-amazoncorretto-11 AS builder

WORKDIR /opt/nmrc-api-build

COPY src/ ./src
COPY pom.xml .

RUN mvn package -Pprod -DskipTests=true -DDB_HOST={DB_HOST} -DDB_USER={DB_USER} -DDB_PASSWORD={DB_PASSWORD} -DDB_PORT={DB_PORT}

############
# application
############
FROM maven:3.6.3-amazoncorretto-11

WORKDIR /opt/nmrc-api

ENV TZ=Asia/Tokyo

COPY --from=builder /opt/nmrc-api-build/target/nomurec-1.0.jar .
RUN jar xf nomurec-1.0.jar BOOT-INF/classes/application-prod.properties
COPY --from=builder /opt/nmrc-api-build/pom.xml .
COPY scripts/ ./scripts

# Download flyway-plugin
RUN mvn -Dflyway.configFiles=BOOT-INF/classes/application-prod.properties flyway:info; exit 0

EXPOSE 8080

ENTRYPOINT ["sh", "scripts/entrypoint_prod.sh"]
