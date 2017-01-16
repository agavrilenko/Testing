package org.my.testing.hazelcast.queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by trash on 18-Oct-16.
 */
public class GettingStarted {
    public static void main( String[] args ) throws InterruptedException {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        Map<Integer, String> customers = hazelcastInstance.getMap( "customers" );
        customers.put( 1, "Joe" );
        customers.put( 2, "Ali" );
        customers.put( 3, "Avi" );
        System.out.println( "Customer with key 1: " + customers.get(1) );
        System.out.println( "Map Size:" + customers.size() );
        BlockingQueue<String> queueCustomers = hazelcastInstance.getQueue( "customers" );
        queueCustomers.offer( "Tom" );
        queueCustomers.offer( "Mary" );
        queueCustomers.offer( "Jane" );
        int i = 10000;
        while (i-- > 0){
            String message = "Hello " + i;
            System.out.println(message);
            queueCustomers.put(message);
        }
        System.out.println( "First customer: " + queueCustomers.poll() );
        System.out.println( "Second customer: "+ queueCustomers.peek() );
        System.out.println( "Queue size: " + queueCustomers.size() );
    }
}
