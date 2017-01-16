package org.my.testing.hazelcast.topic;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import java.util.concurrent.TimeUnit;

/**
 * Created by trash on 23-Oct-16.
 */
public class TopicMonitor {
    public static void main(String[] args) throws InterruptedException {

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        ITopic<Object> myTopic = hazelcastInstance.getTopic("default");

        while (true) {
            System.out.println(myTopic.getLocalTopicStats().getPublishOperationCount());
            System.out.println(myTopic.getLocalTopicStats().getReceiveOperationCount());
            TimeUnit.SECONDS.sleep(30);
        }
    }
}
