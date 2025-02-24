FROM maven:3.9.9-eclipse-temurin-21-alpine

RUN mkdir -p /var/www/finance-ctrl

ADD .docker/java/bin/* /docker/

RUN chmod +x /docker/entrypoint.sh

CMD ["mvn", "package"]

ENTRYPOINT ["/docker/entrypoint.sh"]