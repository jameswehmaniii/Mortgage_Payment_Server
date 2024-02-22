package MtgRequestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MortgageRunnable implements Runnable {
    protected Socket clientSocket = null;
    private Mortgage m;

    public MortgageRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            if (in.readLine().equals("initCalculation")) {
                String arg1,
                       arg2,
                       arg3;
                arg1 = in.readLine();
                arg2 = in.readLine();
                arg3 = in.readLine();

                double annual_interest_rate = Double.parseDouble(arg1);
                double principal_amount = Double.parseDouble(arg2);
                double duration_years = Double.parseDouble(arg3);

                this.m = new Mortgage(annual_interest_rate, principal_amount, duration_years);
            }

            out.println(this.m.monthly_repayments());

        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
