#!/bin/bash
export JAVA_HOME=/opt/java

cd /opt/api/
./bin/dropwizard-test-distribution server var/conf/server.yml
