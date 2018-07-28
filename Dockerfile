FROM  openjdk:10-jdk-slim AS compile

COPY ./ /

RUN ./gradlew clean distTar

FROM  openjdk:10-jdk-slim AS run

COPY --from=compile dropwizard-test-distribution/build/distributions/*.tar /

RUN tar -xf dropwizard-test-distribution-*.tar

CMD dropwizard-test-distribution-*/bin/dropwizard-test-distribution server

