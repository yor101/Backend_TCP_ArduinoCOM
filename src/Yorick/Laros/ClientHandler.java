package Yorick.Laros;

import javax.imageio.IIOException;
import java.awt.desktop.AboutEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler {

    private ServerSocket server;
    private Socket socket;


    public boolean forwardMessage(String message){
        boolean isConnected = true;

        try {
            socket = new Socket();
            socket = server.accept();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            if (server.isBound()){
                isConnected = false;
            }
            output.print(message);


        }catch (IOException e){
            System.out.println("error " + e.getMessage());
        }
        return isConnected;
    }


}
