package es.karmadev.example.subscription;

import es.karmadev.api.channel.data.BaseMessage;
import es.karmadev.api.channel.subscription.AChannelSubscription;
import es.karmadev.api.channel.subscription.event.data.MessageReceiveEvent;

public class MessageSubscription extends AChannelSubscription {

    public void onMessage(final MessageReceiveEvent e) {
        BaseMessage message = e.getMessage();
        long id = message.getId();

        if (id == 500) {
            String name = message.getUTF();
            String nick = message.getUTF();

            System.out.printf("(From a client): %s's nick is: %s%n", name, nick);
        }
    }
}
