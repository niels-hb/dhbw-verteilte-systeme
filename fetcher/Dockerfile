FROM gradle:jdk11 as builder

COPY . /builds/
WORKDIR /builds/fetcher/

RUN gradle bootJar

FROM openjdk:11

WORKDIR /opt/app/
COPY --from=builder /builds/fetcher/build/libs/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]
