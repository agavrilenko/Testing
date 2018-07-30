package org.my.kafka;

import org.junit.Test;

/**
 * Created by trash on 29-Jul-18.
 */
public class SimpleConsumerTest {
    @Test
    public void test() {
        SimpleConsumer consumer = new SimpleConsumer();
        consumer.consume();
    }

}