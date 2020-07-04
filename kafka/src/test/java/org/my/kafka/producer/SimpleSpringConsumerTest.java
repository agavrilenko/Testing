package org.my.kafka.producer;

import org.junit.Ignore;
import org.junit.Test;
import org.my.kafka.consumer.SimpleSpringConsumer;

public class SimpleSpringConsumerTest {
    @Test
    @Ignore
    public void testProcude() throws InterruptedException {
        SimpleSpringConsumer consumer = new SimpleSpringConsumer();
        consumer.consume();
        Thread.sleep(100000);

    }

}