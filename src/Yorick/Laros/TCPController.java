package Yorick.Laros;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class TCPController extends Thread{


    public void TCPHandler(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isBound()) {
                System.out.println("connected");
            }

            int value;
                        String message;

            while ((value = in.read()) != -1) {
                //c = (char)value;
                message = Character.toString((char) value);
                System.out.println(message);

            }

        } catch (
                IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}
