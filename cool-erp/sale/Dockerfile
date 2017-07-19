FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-sale.jar /sopra-sale/sopra-sale.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-sale/sopra-sale.jar"]