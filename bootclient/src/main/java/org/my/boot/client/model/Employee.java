package org.my.boot.client.model;

/**
 * Created by trash on 02-Jan-17.
 */
public class Employee {
    private String position;
    private Person person;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", person=" + person +
                '}';
    }
}
