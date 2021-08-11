#!/usr/bin/env zsh

java -jar -Dspring.profiles.active=native spring-cloud/config-server/build/libs/*.jar &
java -jar spring-cloud/gateway/build/libs/*.jar &
java -jar spring-cloud/eureka-server/build/libs/*.jar &
java -jar microservices/customer-service/customer-server/build/libs/*.jar &
java -jar microservices/plm-service/plm-server/build/libs/*.jar &
java -jar microservices/product-service/product-server/build/libs/*.jar &
java -jar microservices/service-service/service-server/build/libs/*.jar &
