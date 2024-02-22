package MtgRequestServer;


public class MortgageServer {

    public static void main(String[] args) {
        System.out.println("Server Bootup");
        SocketServer s = new SocketServer();
        s.runServer();

    }

}
