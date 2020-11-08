package Yorick.Laros;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TCPController extends Thread {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader in;

    private int portNumber;

    public TCPController(int portNumber) {
        this.portNumber = portNumber;
    }


    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isBound()) {
                System.out.println("connected");
            }

            char c;
            int value;
            String s;

            while ((value = in.read()) != -1) {
                c = (char)value;
                s = Character.toString(c);
                final String message = s;
                System.out.println(message);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
