package MtgRequestServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    int portNumber = 44444;
    ServerSocket serverSocket = null;

    public void runServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//every connection, create socket, and store connection
        while (!serverSocket.isClosed()) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new MortgageRunnable(clientSocket)).start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}


