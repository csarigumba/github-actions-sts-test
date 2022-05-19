#!/bin/bash
mvn -Dflyway.configFiles=BOOT-INF/classes/application-prod.properties flyway:migrate
java -jar nomurec-1.0.jar
