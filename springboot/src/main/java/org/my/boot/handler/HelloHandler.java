package org.my.boot.handler;

/**
 * Created by trash on 12-Dec-16.
 */
public class HelloHandler {
    public String returnHello() {
        return "Hello from " + this.getClass().toString();
    }
}
