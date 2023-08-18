#!/bin/bash
dos2unix mvnw
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" &
# Avec chargement du fichier de configuration supplémentaire "application-docker.properties"
#./mvnw spring-boot:run -Dspring-boot.run.profiles=docker -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" &
while true; do
  inotifywait -e modify,create,delete,move -r ./src/ && ./mvnw compile
done
