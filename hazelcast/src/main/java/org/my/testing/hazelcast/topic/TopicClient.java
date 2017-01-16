package org.my.testing.hazelcast.topic;

import com.hazelcast.core.*;

import java.util.GregorianCalendar;

/**
 * Created by trash on 23-Oct-16.
 */
public class TopicClient implements MessageListener<MyEvent> {

    //    private final Executor messageExecutor = Executors.newSingleThreadExecutor();
    private final String clientName;

    public TopicClient(String name) {
        this.clientName = name;
    }

    public TopicClient() {
        this.clientName = "Created at " + GregorianCalendar.getInstance().getTime();
    }



    public static void main(String[] args) {
        TopicClient client = new TopicClient("Client created manually" + GregorianCalendar.getInstance().getTime());
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        ITopic<MyEvent> topic = hazelcastInstance.getTopic("default");
        topic.addMessageListener(client);
    }

    @Override
    public void onMessage(Message<MyEvent> message) {
        MyEvent myEvent = message.getMessageObject();
//        messageExecutor.execute(() -> {
        try {
            System.out.println("Clint name " + this.clientName);
            System.out.println("Current thread is " + Thread.currentThread().getName());
            myEvent.perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        });

    }
}
