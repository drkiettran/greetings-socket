# greetings-socket project

This project is a spin off my-app application. The code is splitted into
a server and a client pieces that communicates over tcp/ip sockets.

## Run

To run tests:

```bash

mvn clean test
mvn clean package
jar -t target/greetings-socket-1.0-SNAPSHOT-jar-with-dependencies.jar

java -cp target/greetings-socket-1.0-SNAPSHOT-jar-with-dependencies.jar edu.harrisburgu.cisc525.app.Main server 8080

java -cp target/greetings-socket-1.0-SNAPSHOT-jar-with-dependencies.jar edu.harrisburgu.cisc525.app.Main client localhost 8080 "John Doe"

```

The output should be, ` Received Hello, John Doe from SaintGoretti/49692@SaintGoretti from SaintGoretti/45532@SaintGoretti`
