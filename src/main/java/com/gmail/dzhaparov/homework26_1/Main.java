package com.gmail.dzhaparov.homework26_1;

public class Main {
    public static void main(String[] args) {

        User user = new User("John Doe");


        Address address = new Address("123 Main St", "Springfield", "12345");


        user.setAddress(address);


        System.out.println(user);
    }
}
