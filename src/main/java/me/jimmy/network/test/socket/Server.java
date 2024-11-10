package me.jimmy.network.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static me.jimmy.network.test.util.MyLogger.log;

public class Server {
    private ExecutorService es = Executors.newFixedThreadPool(2);
    private final int PORT;

    public Server(int PORT) {
        this.PORT = PORT;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            log("socket 연결 : " + socket);

            es.submit(new HttpRequestHandler(socket));
        }
    }
}
