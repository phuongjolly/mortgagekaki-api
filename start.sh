#!/usr/bin/env bash
MYSQL_USERNAME=root
MYSQL_PASSWORD=TheThreeTop4811
MYSQL_URL=jdbc:mysql://localhost:3306/osmr?useSSL=false
PORT=8081

APP=loan-api-0.0.1-SNAPSHOT.jar

java -Dspring.profiles.active=production -Dserver.port=${PORT} -DMYSQL_USERNAME=${MYSQL_USERNAME} -DMYSQL_PASSWORD=${MYSQL_PASSWORD} -DMYSQL_URL=${MYSQL_URL} -jar ${APP} >logs.log 2>&1 &

echo "Application has started"
