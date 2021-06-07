FROM openjdk:8-jdk-alpine 
VOLUME D:\\workspace\\navat\\harborland\\backend-template-service\\config
COPY build/libs/member-service-1.0.1.jar app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]