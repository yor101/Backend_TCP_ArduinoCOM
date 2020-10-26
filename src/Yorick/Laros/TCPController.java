package Yorick.Laros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPController {

    public void TCPHandler(int portNumber){
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if (socket.isBound()){
                System.out.println("connected");
            }
            int value;

            // reads to the end of the stream
            while((value = in.read()) != -1) {
                // converts int to character
                char c = (char)value;

                // prints character
                System.out.println(c);
            }

        }catch (
                IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
