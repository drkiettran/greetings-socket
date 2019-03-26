package edu.harrisburgu.cisc525.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public Client(String host, Integer port, String name) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        name = String.format("%s from %s/%s", name, 
                            InetAddress.getLocalHost().getHostName(),
                            ManagementFactory.getRuntimeMXBean().getName());

        try (Socket clientSocket = new Socket(host, port)) {
            LOGGER.info("Connected on port {}", clientSocket.getPort());
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.write(name);
            out.write("\n");
            out.flush();

            LOGGER.info("Sent {}", name);
            LOGGER.info("Waiting for input ...");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            LOGGER.info("Received {}", in.readLine());

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
	}

	
}