package MortgageClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MortgageClient {
    public static void main(String[] args) {
        String hostName = "127.0.0.1";
        int portNumber = 44444;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        InputStreamReader ir;
        BufferedReader stdIn;


        try {
            System.out.println("Welcome to the Mortgage Server!");
            clientSocket = new Socket(hostName, portNumber);
            // Create our IO streams
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            ir = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(ir);
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            out.println("initCalculation");


            System.out.println("Enter the loan percentage rate: ");
            out.println(stdIn.readLine());
            System.out.println("Enter the loan amount: ");
            out.println(stdIn.readLine());
            System.out.println("Enter the loan duration: ");
            out.println(stdIn.readLine());


            System.out.println("Server says mortgage repayment is: " + in.readLine());

        } catch(UnknownHostException e) {
            System.exit(1);
        } catch(IOException e) {
           System.exit(1);
        }

    }
}
