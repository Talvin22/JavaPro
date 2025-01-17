package com.gmail.dzhaparov.homework33_1.client;


import com.gmail.dzhaparov.homework33_1.utils.NetworkProperty;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    private static Logger logger = Logger.getLogger(Client2.class);

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(NetworkProperty.HOST, NetworkProperty.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            logger.info("Client connected");
            logger.info("Write your name: ");
            String name = scanner.nextLine();
            out.println(name);


            Thread listenerThread = new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        logger.info("*" + serverResponse);
                    }
                } catch (IOException e) {
                    logger.error("[CLIENT] error in listener thread: " + e.getMessage());
                }
            });

            listenerThread.start();

            String userCommand;
            while (true) {
                userCommand = scanner.nextLine();
                out.println(userCommand);

                if ("exit".equalsIgnoreCase(userCommand)) {
                    logger.info("[CLIENT] Вихід з програми");
                    break;
                }
            }

        } catch (Exception e) {
            logger.error("[CLIENT] error: " + e.getMessage());
        }
    }
}
