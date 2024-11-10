package me.jimmy.network.test.socket;

import java.io.IOException;

import static me.jimmy.network.test.util.MyLogger.log;

public class ServerMain {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("ServerMain start");
        Server server = new Server(PORT);
        server.start();

        log("ServerMain end");
    }
}
