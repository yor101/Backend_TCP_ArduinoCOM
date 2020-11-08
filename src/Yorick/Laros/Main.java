package Yorick.Laros;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	    TCPController tcp = new TCPController(4099);
	    tcp.run();
    }
}
