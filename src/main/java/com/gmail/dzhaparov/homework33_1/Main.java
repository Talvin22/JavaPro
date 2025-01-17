package com.gmail.dzhaparov.homework33_1;

import com.gmail.dzhaparov.homework33_1.server.ChatServer;

public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            ChatServer server = new ChatServer();
            server.startServer();
        }).start();

    }
}