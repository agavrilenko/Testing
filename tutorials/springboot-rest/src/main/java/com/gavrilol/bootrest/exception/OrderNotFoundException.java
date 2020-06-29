package com.gavrilol.bootrest.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(Long id) {
        super(String.format("Order with id [%s] is not found", id));
    }

}
