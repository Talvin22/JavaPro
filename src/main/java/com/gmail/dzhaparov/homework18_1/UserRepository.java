package com.gmail.dzhaparov.homework18_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users = new ArrayList<User>();

    void addUser(User user) {
        users.add(user);
    }


    Optional<User> findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();

    }

    Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    Optional<List<User>> findAllUsers() {
        return users.isEmpty() ? Optional.empty() : Optional.of(new ArrayList<>(users));
    }
}
