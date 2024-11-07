package com.gmail.dzhaparov.homework18_1;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        UserRepository ur = new UserRepository();

        ur.addUser(new User(1, "Bella", "bella@gmail.com"));
        ur.addUser(new User(2, "Bob", "bob@gmail.com"));
        ur.addUser(new User(3, "Alice", "alice@gmail.com"));
        ur.addUser(new User(4, "Bob", "bob@gmail.com"));

        Optional<User> userById = ur.findUserById(2);
        System.out.println(userById);

        Optional<User> userByEmail = ur.findUserByEmail("alice@gmail.com");
        System.out.println(userByEmail);

        Optional<User> userByEmail2 = ur.findUserByEmail("alicce@gmail.com");//Якщо користувача не було знайдено, то повернеться пустий Optional
        System.out.println(userByEmail2);

        Optional<List<User>> allUsers = ur.findAllUsers();
        System.out.println(allUsers);

    }
}
