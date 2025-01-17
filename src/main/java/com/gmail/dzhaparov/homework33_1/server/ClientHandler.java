package com.gmail.dzhaparov.homework33_1.server;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private static final Logger logger = Logger.getLogger(ClientHandler.class);
    private final Socket clientSocket;
    private final String clientName;
    private final ConcurrentHashMap<String, Socket> clients;

    public ClientHandler(ConcurrentHashMap<String, Socket> clients, Socket clientSocket, String clientName) {
        this.clients = clients;
        this.clientSocket = clientSocket;
        this.clientName = clientName;
    }


    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                logger.info("[SERVER] received from " + clientName + ": " + inputLine);

                // Отправляем подтверждение клиенту
                sendMessageToAll(clientName + ": " + inputLine);

                if ("exit".equalsIgnoreCase(inputLine)) {
                    logger.info("[SERVER] " + clientName + " disconnected");
                    clients.remove(clientName);
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("[SERVER] error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                logger.error("[SERVER] error: " + e.getMessage());
            }
        }
    }
    private void sendMessageToAll(String message) {
        for (Map.Entry<String, Socket> entry : clients.entrySet()) {
            String clientName = entry.getKey();
            Socket clientSocket = entry.getValue();

            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                logger.error("[SERVER] Unable to send message to " + clientName, e);
            }
        }
    }
}