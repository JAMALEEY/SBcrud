#!/bin/bash
JAVA_HOME=/usr/bin/java
./mvnw jetty:stop
./mvnw clean
./mvnw install
./mvnw jetty:run