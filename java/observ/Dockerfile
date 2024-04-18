FROM maven:3.9.6-eclipse-temurin-21
ADD . /code
WORKDIR /code
RUN mvn clean package -DskipTests=true
CMD mvn spring-boot:run
