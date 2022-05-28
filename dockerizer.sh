
 mvn -f  microservice/microservice-shared/pom.xml install
 mvn -f microservice/microservice-app/pom.xml spring-boot:build-image -DskipTests
 mvn  -f microservice/microservice-app-kotlin/pom.xml spring-boot:build-image -DskipTests
 mvn  -f microservice/microservice-app-reactive/pom.xml spring-boot:build-image -DskipTests
 mvn  -f microservice-caller/pom.xml spring-boot:build-image -DskipTests
 mvn -f  microservice-caller-reactive/pom.xml spring-boot:build-image -DskipTests

 docker-compose up -d