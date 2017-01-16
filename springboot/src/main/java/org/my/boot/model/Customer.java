package org.my.boot.model;

/**
 * Created by trash on 14-Dec-16.
 */
public class Customer {
    private User user;
    private String occupation;

    public Customer(User user, String occupation) {
        this.user = user;
        this.occupation = occupation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
