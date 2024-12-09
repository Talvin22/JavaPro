package com.gmail.dzhaparov.homework26_1;

public class User {
    private String name;
    private Address address;


    public User(String name) {
        this.name = name;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: " + name + ", Address: " + (address != null ? address.toString() : "No Address");
    }
}