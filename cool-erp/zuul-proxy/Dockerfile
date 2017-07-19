FROM java:openjdk-8u77-jre-alpine

MAINTAINER Daniel Lavoie <dlavoie@live.ca>

ADD target/sopra-zuul-proxy.jar /sopra-zuul-proxy/sopra-zuul-proxy.jar

EXPOSE 8080

CMD ["java", "-Xmx128m", "-jar", "/sopra-zuul-proxy/sopra-zuul-proxy.jar"]