FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-reception.jar /sopra-reception/sopra-reception.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-reception/sopra-reception.jar"]