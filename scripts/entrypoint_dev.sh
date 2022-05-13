#!/bin/bash
mvn -Dflyway.configFiles=src/main/resources/application-dev.properties flyway:migrate
java -jar nomurec-1.0.jar
