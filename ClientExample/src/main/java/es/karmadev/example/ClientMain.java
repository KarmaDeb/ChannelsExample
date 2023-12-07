package es.karmadev.example;

import es.karmadev.api.channel.future.ConnectionFuture;
import es.karmadev.api.netty.Client;
import es.karmadev.example.subscription.MessageSubscription;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        ConnectionFuture future = client.connect("127.0.0.1", 5500);

        client.subscribe(new MessageSubscription());
        future.onComplete((task) -> {
            if (task.isSuccess()) {
                System.out.println("Successfully connected to server!");
            } else {
                System.out.println("Failed to connect to the server");
                Throwable error = task.getError();
                if (error != null) error.printStackTrace();
            }
        });
    }
}
