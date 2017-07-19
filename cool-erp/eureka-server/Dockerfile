FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-eureka-server.jar /sopra-eureka-server/sopra-eureka-server.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-eureka-server/sopra-eureka-server.jar"]