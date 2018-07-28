FROM  openjdk:10-jdk-slim

COPY dropwizard-test-distribution/build/distributions/dropwizard-test-distribution-*.tar /

RUN tar -xf dropwizard-test-distribution-*.tar

CMD dropwizard-test-distribution-*/bin/dropwizard-test-distribution server
