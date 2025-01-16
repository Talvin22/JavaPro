package com.gmail.dzhaparov.homework33_1.server;

import com.gmail.dzhaparov.homework33_1.utils.NetworkProperty;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private static Logger logger = Logger.getLogger(ChatServer.class);
    private Long clientCount;
    private ConcurrentHashMap<String, Socket> clients = new ConcurrentHashMap<>();

    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(NetworkProperty.PORT)) {
            logger.info("[SERVER] was successfully started on port: " + NetworkProperty.PORT);

            while(true){
                Socket socket = serverSocket.accept();
                clientCount++;
                String clientName = clientCount + "_client";
                clients.put(clientName, socket);
                logger.info("[SERVER] " + clientName + " connected");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
