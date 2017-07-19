FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-purchase-order.jar /sopra-purchase-order/sopra-purchase-order.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-purchase-order/sopra-purchase-order.jar"]