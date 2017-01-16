package org.my.boot.controller;

import org.my.boot.model.Customer;
import org.my.boot.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by trash on 14-Dec-16.
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long user) {
        User u = new User("name " + user, "lastName " + user);
        return u;
    }

    @RequestMapping(value = "/{user}/customers", method = RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {
        User u = new User("name " + user, "lastName " + user);
        Customer c = new Customer(u, "occupateion " + user);
        return Arrays.asList(c);
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
        return null;
    }
}
