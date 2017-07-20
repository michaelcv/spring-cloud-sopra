FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/product.jar /sopra-product/product.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-product/product.jar"]
