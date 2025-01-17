package com.gmail.dzhaparov.homework33_1.server;

import com.gmail.dzhaparov.homework33_1.utils.NetworkProperty;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private static Logger logger = Logger.getLogger(ChatServer.class);
    private Long clientCount = 0L;
    private ConcurrentHashMap<String, Socket> clients = new ConcurrentHashMap<>();

    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(NetworkProperty.PORT)) {
            logger.info("[SERVER] was successfully started on port: " + NetworkProperty.PORT);

            while(true){
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                clientCount++;
                String clientName = in.readLine();
                clients.put(clientName, socket);

                logger.info("[SERVER] " + clientName + " connected");

                ClientHandler clientHandler = new ClientHandler(clients, socket, clientName);
                new Thread(clientHandler).start();
            }

        } catch (Exception e) {
            logger.error("[SERVER] " + e.getMessage());
        }
    }


}
