package org.my.testing.hazelcast.topic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import java.util.concurrent.TimeUnit;

/**
 * Created by trash on 23-Oct-16.
 */
public class MessagePublisher {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        ITopic topic = hazelcastInstance.getTopic("default");
        for (int i = 0; i < 1000; i++) {
            topic.publish(new MyEvent("Published my event " + i));
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
}
