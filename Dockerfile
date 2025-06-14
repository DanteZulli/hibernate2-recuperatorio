FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy the project files
COPY . .

# Enable remote debugging and hot reload
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -Dspring.devtools.restart.enabled=true -Dspring.devtools.remote.secret=mysecret"

# Command to run the application with Maven
CMD ["mvn", "spring-boot:run"] 