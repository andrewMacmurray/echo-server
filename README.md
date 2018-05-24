# Echo Server
Java echo server that echos back requests from a client

## Run the server


Start the echo server with:

```$xslt
> ./gradlew runServer --console=plain -q
```

And connect to it with the echo client:

```$xslt
> ./gradlew runClient --console=plain -q 
```

You can then type a message into the echo client and it should echo your message back