package org.my.testing.hazelcast.topic;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by trash on 23-Oct-16.
 */
public class MyEvent implements Serializable {
    private final String name;

    public MyEvent(String name) {
        this.name = name;
    }

    public void perform() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("Running job " + name);
    }
}
