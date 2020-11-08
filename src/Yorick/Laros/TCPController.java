package Yorick.Laros;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPController{

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader in;



    public void TCPHandler(int portNumber) {

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

            while ((value = in.read()) != -1) {
                c = (char)value;
                System.out.print(c);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
