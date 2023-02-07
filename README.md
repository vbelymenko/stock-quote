# Stock Quote

## Techologies

- Kafka broker
- Schema registry
- PostgresQL database
- Liquibase migration tool
- MapStruct mapper

## Launch an app

Go into 'docker/database' and 'docker/kafka' directory and run database and kafka docker compose file. Kafka has two configurations: single node and two nodes.
Then go into 'stock-quote-avro-model' and execute command
```sh
mvn clean install
```
This command create an Maven dependency which is using in consumer and producer app

Then launch consumer and producer.
