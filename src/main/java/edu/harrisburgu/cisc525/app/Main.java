package edu.harrisburgu.cisc525.app;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        if (args.length < 1) {
            System.out.println("**** java edu.harrisburgu.cisc525.app.Main server port | client host port <text> ****");
            return;
        }

        if (args[0].equalsIgnoreCase("client")) {
            if (args.length < 4) {
                System.out.println("**** java edu.harrisburgu.cisc525.app.Main client host port <text> ****");
                return;
            }
            new Client(args[1], Integer.valueOf(args[2]), args[3]);
        } else if (args[0].equalsIgnoreCase("server")) {
            if (args.length < 2) {
                System.out.println("**** java edu.harrisburgu.cisc525.app.Main server port ****");
                return;
            }
            new Server(Integer.valueOf(args[1]));
        }
    }
}