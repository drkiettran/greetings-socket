package edu.harrisburgu.cisc525.app;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    public static void main(String... args) throws IOException {
        if (args.length < 2) {
            LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main server port | client host port <text> ****");
            return;
        }
        LOGGER.info("mode: {}", args[0]);
        if (args[0].equalsIgnoreCase("client")) {
            if (args.length < 4) {
                LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main client host port <text> ****");
                return;
            }
            new Client(args[1], Integer.valueOf(args[2]), args[3]);
        } else if (args[0].equalsIgnoreCase("server")) {
            if (args.length < 2) {
                LOGGER.info("**** java edu.harrisburgu.cisc525.app.Main server port ****");
                return;
            }
            new Server(Integer.valueOf(args[1]));
        } else {
            LOGGER.info(">>> java edu.harrisburgu.cisc525.app.Main server port | client host port <text> <<<");
        }
    }
}