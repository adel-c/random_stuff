export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost/mydatabase
export SPRING_DATASOURCE_PASSWORD=secret
export SPRING_DATASOURCE_USERNAME=myuser


./mvnw -DskipTests -Pnative native:compile        
./mvnw spring-boot:test-run 
