package com.gmail.dzhaparov.homework33_1.client;


import com.gmail.dzhaparov.homework33_1.utils.NetworkProperty;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

    private static Logger logger = Logger.getLogger(Client1.class);
    public static void main(String[] args) {


        try (Socket clientSocket = new Socket(NetworkProperty.HOST, NetworkProperty.PORT)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            logger.info("Client connected");

            String userCommand;

            while ((userCommand = in.readLine()) != null) {
                out.println(userCommand);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
