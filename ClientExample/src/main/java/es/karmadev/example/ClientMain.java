package es.karmadev.example;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.future.ConnectionFuture;
import es.karmadev.api.netty.Client;
import es.karmadev.api.netty.message.MessageBuilder;
import es.karmadev.example.subscription.MessageSubscription;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        ConnectionFuture future = client.connect("127.0.0.1", 5500);

        client.subscribe(new MessageSubscription());
        future.onComplete((task) -> {
            if (task.isSuccess()) {
                System.out.println("Successfully connected to server!");

                try {
                    MessageBuilder builder = new MessageBuilder();
                    builder.writeUTF("John Doe");
                    builder.writeUTF("Karma");

                    BaseMessage message = builder.build(500);
                    task.getConnection().write(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Failed to connect to the server");
                Throwable error = task.getError();
                if (error != null) error.printStackTrace();
            }
        });
    }
}
