FROM maven:3.9.6-eclipse-temurin-21
ADD . /code
WORKDIR /code
RUN mvn -Duser.home=/var/maven clean package -DskipTests=true
CMD mvn -Duser.home=/var/maven spring-boot:run
