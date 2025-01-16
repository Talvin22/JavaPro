package com.gmail.dzhaparov.homework33_1.server;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private static Logger logger = Logger.getLogger(ClientHandler.class);
    private Socket clientSocket;
    private String clientName;
    private final ConcurrentHashMap<Integer, ClientHandler> clients;

    public ClientHandler(ConcurrentHashMap<Integer, ClientHandler> clients, Socket clientSocket, String clientName) {
        this.clients = clients;
        this.clientSocket = clientSocket;
        this.clientName = clientName;
    }


    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                logger.info("[SERVER] got new message from " + clientName + ": " + inputLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}