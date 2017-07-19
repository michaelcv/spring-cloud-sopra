FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-inventory.jar /sopra-inventory/sopra-inventory.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-inventory/sopra-inventory.jar"]