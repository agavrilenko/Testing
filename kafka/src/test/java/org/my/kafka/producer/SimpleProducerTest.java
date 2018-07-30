package org.my.kafka.producer;

import org.junit.Test;

/**
 * Created by trash on 29-Jul-18.
 */
public class SimpleProducerTest {
    @Test
    public void test() {
        SimpleProducer producer = new SimpleProducer();
        producer.produce();
    }

}