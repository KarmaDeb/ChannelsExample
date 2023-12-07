# ChannelsExample
Example implementation for KarmaAPI channelings netty API

# [Client implementation](https://github.com/KarmaDeb/ChannelsExample/blob/master/ClientExample/src/main/java/es/karmadev/example/ClientMain.java)
```java
public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        ConnectionFuture future = client.connect("127.0.0.1", 5500);
    }
}
```

# [Server implementation](https://github.com/KarmaDeb/ChannelsExample/blob/master/ServerExample/src/main/java/es/karmadev/example/ServerMain.java)
```java
public class Main {

    public static void main(String[] args) {
        Server server = new Server("127.0.0.1", 5500);
        Future future = server.start();
    }
}
```