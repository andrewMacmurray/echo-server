# Echo Server
Java echo server that echos back requests from a client

## Run the server

first build the jars with

```$xslt
> ./gradlew assemble
```

Then start the echo server with:

```$xslt
> java -jar build/libs/echo-server-1.0-SNAPSHOT.jar
```

And connect to it with the echo client:

```$xslt
> java -jar build/libs/echo-client-1.0-SNAPSHOT.jar
```

You can then type a message into the echo client and it should echo your message back