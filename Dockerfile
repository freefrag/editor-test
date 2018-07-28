FROM  openjdk:10-jdk-slim

COPY dropwizard-test-distribution/build/distributions/dropwizard-test-distribution-0.0.1.dirty.tar /

RUN tar -xf dropwizard-test-distribution-0.0.1.dirty.tar

CMD dropwizard-test-distribution-0.0.1.dirty/bin/dropwizard-test-distribution server
