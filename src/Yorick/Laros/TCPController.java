package Yorick.Laros;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TCPController extends Thread{

    private final List<String> myStringList = new ArrayList<>();


    public void TCPHandler(int portNumber) {

        //char STX = 2;
        //char ETX = 3;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isBound()) {
                System.out.println("connected");
            }

            int value;
            String message;

            while ((value = in.read()) != -1) {
                //c = (char)value;
                message = Character.toString((char) value);
                myStringList.add(message);
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
