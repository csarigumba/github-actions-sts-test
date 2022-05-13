# My Data Center API

For Nomurec

## 1. Local Environment Setup

1.1 Install [Amazon Corretto 11 JDK](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)

1.2 Install and setup [Maven 3.6.3 or latest](https://www.tutorialspoint.com/maven/maven_environment_setup.htm)

1.3 Install [MySQL 8.0.29](https://www.mysql.com/downloads/)

- As alternative option, you can use docker to avoid MySQL version conflicts between projects.
- See. https://ap-northeast-1.console.aws.amazon.com/codesuite/codecommit/repositories/nmrc-api/browse/refs/heads/master/--/docker?region=ap-northeast-1

1.4 Download [Lombok](https://projectlombok.org/download) jar. To install, double click the jar file and point to your IDE of choice when prompted.


## 2. API Setup

2.1 Clone the project using command `git clone codecommit::ap-northeast-1://geco-sandbox-role@nmrc-api`

2.1.1 We will be using Github but since it is not ready yet, we will use the CodeCommit repository in Geco sandbox in managing our changes.

2.2 Checkout the develop branch. (Or depends on any situation, checkout the appropriate branch). Currently, there is only one branch which is the master branch.

2.3 `src/main/resources/application-dev.properties` are already pre-configured and you may leave it as it is. You may update the parameters based on your local setup when needed.


## 3. Flyway Migration

Run the flyway migration scripts to initialize your local database.

3.1 `src/main/resources/application-dev.properties` are already pre-configured and you may leave it as it is. You may update the parameters based on your local setup when needed.

3.2 Go to the project's root directory, run the command `mvn clean -Dflyway.configFiles=src/main/resources/application-dev.properties flyway:migrate`

3.2.1 Make sure MySQL docker are already started before running the above command.

## 4. Running the API locally via Command line (cmd)

4.1 Go to the project's root directory, run the command `mvn spring-boot:run -Dspring-boot.run.profiles=dev`

4.2 Terminal output will looks like below.

```
2022-05-10 10:52:35.458  INFO 5944 --- [           main] jp.co.suntory.nmrc.SpringApiApplication  : The following 1 profile is active: "dev"
2022-05-10 10:52:38.167  INFO 5944 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8081 (http)
2022-05-10 10:52:38.191  INFO 5944 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-05-10 10:52:38.192  INFO 5944 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.62]
2022-05-10 10:52:38.419  INFO 5944 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-05-10 10:52:38.428  INFO 5944 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2885 ms
2022-05-10 10:52:39.722  INFO 5944 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2022-05-10 10:52:39.752  INFO 5944 --- [           main] jp.co.suntory.nmrc.SpringApiApplication  : Started SpringApiApplication in 5.154 seconds (JVM running for 5.773)
```

## 5. Running the API locally via Eclipse IDE
5.1 Activate the Maven profile by pressing `CTRL + ALT + P`. The command will show a popup window that has a list of Maven profiles then select a profile (e.g dev) and click OK.

5.2 Right-click the project and select `Run As -> Java Application`. This will show a popup window, then select the `SpringApiApplication` and click OK.

5.3 It will show the same terminal output when running the API via Command line.

## 6. Verify API is running
6.1 Open http://localhost:8080/swagger-ui.html on your browser.

## 7. Testing

5.1 run the command `mvn test`

## Create Docker image locally for dev
1. Edit `src/main/resources/application-dev.properties` parameters based on your local setup when needed. By default, dev properties are already pre-configured and you may leave it as it is.
2. Go to the project's root directory, run the command `docker build -f dev.Dockerfile -t nomurec:latest .`
3. Create a docker container an run it using this command, `docker run --name=nmrc-api -p8080:8080  nomurec:latest`
4. Open http://localhost:8080/swagger-ui.html on your browser to verify the application.

## Create Docker image locally for prod

1. Edit `src/main/resources/application-prod.properties` parameters based on your local setup when needed.<br>
TODO : See. application.proerties configuration sheet.

2. Go to the project's root directory, run the command `docker build -f prod.Dockerfile -t nomurec:latest .`

3. Create a docker container an run it using this command, `docker run --name=nmrc-api -p8080:8080  nomurec:latest`

4. Open http://localhost:8080/swagger-ui.html on your browser to verify the application.



## Github Actions (Deploy Flow)
- TODO: 
- Pending: Since we do not have Github account yet for this project.
