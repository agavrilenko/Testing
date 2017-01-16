package org.my.testing.hazelcast.queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.BlockingQueue;

/**
 * Created by trash on 18-Oct-16.
 */
public class GettingStartedClient {
    public static void main(String[] args) throws InterruptedException {
        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("customers");
        BlockingQueue<String> customers = client.getQueue("customers");
        System.out.println("Map Size:" + map.size());
        map.keySet().stream().forEach((key) ->
                System.out.println(map.remove(key))
        );
        while (true) {
            System.out.println(customers.take());
        }
    }
}
