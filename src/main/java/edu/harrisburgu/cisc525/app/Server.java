package edu.harrisburgu.cisc525.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
    
    public Server(int port) throws IOException {
        try (ServerSocket listener = new ServerSocket(port)) {
            while (true) {
                LOGGER.info("The greetings server is running on port {}", port);
                BufferedReader in = null;
                PrintWriter out = null;
                try (Socket socket = listener.accept()) {
                    LOGGER.info("Connected on {}", socket.getPort());
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String name = in.readLine();
                    LOGGER.info("Received {} ", name.toString());
                    Greetings greetings = new Greetings();

                    out = new PrintWriter(socket.getOutputStream(), true);
                    String greetingsMsg = greetings.hello(name) + "\n";
                    out.println(greetingsMsg);
                    out.flush();
                    LOGGER.info("Done and wrote {} ... ", greetingsMsg);
                } finally {
                    LOGGER.info("Close in/out streams");
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }
        }
    }
}

