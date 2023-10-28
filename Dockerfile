FROM amazoncorretto:17.0.9-al2023-headless

WORKDIR /opt/service

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/opt/service/app.jar"]