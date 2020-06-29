package com.gavrilol.bootrest.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(Long id) {
        super(String.format("Employee with id [%s] is not found", id));
    }

}
