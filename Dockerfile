FROM maven:3.9.8-amazoncorretto-17 AS build
WORKDIR /build
COPY src ./src
COPY pom.xml ./
RUN mvn package

FROM openjdk:17
WORKDIR /app
COPY --from=build /build/target/CollegeSchedule*jar ./CollegeSchedule.jar
EXPOSE 9999
CMD ["java", "-jar", "CollegeSchedule.jar"]