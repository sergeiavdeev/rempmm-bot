FROM alpine/java:21-jdk

WORKDIR /app

ADD target/rempmm-bot-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "rempmm-bot-0.0.1-SNAPSHOT.jar"]