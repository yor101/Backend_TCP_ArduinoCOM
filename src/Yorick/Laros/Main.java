package Yorick.Laros;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static final int portNumber = 4099;

    public static void main(String[] args) {
	    try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (socket.isBound()){
                System.out.println("connected");
            }
            int value = 0;

            // reads to the end of the stream
            while((value = in.read()) != -1) {
                // converts int to character
                char c = (char)value;

                // prints character
                System.out.println(c);
            }

        }catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
