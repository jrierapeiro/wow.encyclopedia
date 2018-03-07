# WOW Encyclopedia

## My first dropwizard APP

How to start the encyclopedia application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/encyclopedia-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

# Example config.yml

urlsConfiguration:
  battleNetApi:
    key: #########
    url: https://eu.api.battle.net/wow

logging:
  level: INFO
  loggers:
    wow: DEBU
