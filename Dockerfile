FROM eclipse-temurin:21

LABEL maintainer="bazlur@jugbd.org" \
      version="1.0" \
      description="Spring Boot Application"

WORKDIR /app
COPY build/libs/helloworld-0.0.1-SNAPSHOT.jar /app/helloworld-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/helloworld-0.0.1-SNAPSHOT.jar"]
