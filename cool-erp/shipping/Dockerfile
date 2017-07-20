FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-shipping.jar /sopra-shipping/sopra-shipping.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-shipping/sopra-shipping.jar"]
