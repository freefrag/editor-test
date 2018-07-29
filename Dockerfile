#FROM  openjdk:10-jdk-slim AS compile
#
#COPY ./ /
#
#RUN ./gradlew clean distTar

FROM  openjdk:10-jdk-slim

COPY dropwizard-test-distribution/build/distributions/*.tar /

RUN tar -xf dropwizard-test-distribution-*.tar

CMD cd dropwizard-test-distribution-* && ./bin/dropwizard-test-distribution server var/conf/server.yml

