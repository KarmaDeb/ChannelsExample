package es.karmadev.example;

import es.karmadev.api.channel.future.Future;
import es.karmadev.api.netty.Server;
import es.karmadev.example.subscription.MessageSubscription;

public class ServerMain {

    public static void main(String[] args) {
        Server server = new Server("127.0.0.1", 5500);
        Future future = server.start();

        server.subscribe(new MessageSubscription());
        future.addListener((task) -> {
            if (task.isSuccess()) {
                System.out.println("Successfully started server!");
            } else {
                System.out.println("Failed to start server");
                Throwable error = task.getCause();
                if (error != null) error.printStackTrace();
            }
        });;
    }
}
