FROM  openjdk:10-jdk-slim

COPY dropwizard-test-distribution/build/distributions/*.tar /

RUN tar -xf dropwizard-test-distribution-*.tar

CMD dropwizard-test-distribution-*/bin/dropwizard-test-distribution server
