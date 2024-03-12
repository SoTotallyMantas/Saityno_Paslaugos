package lt.viko.eif.m.trojanovskis.student.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            System.out.println("Message received: " + greeting);
            if ("hello java server ".equals(greeting)) {
                out.println("hello client");
            } else {
                out.println("unrecognised greeting");
            }

        } catch (IOException e) {
            System.out.println("Exception occured:" + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Exception occured:" + e.getMessage());
        }
    }
    /*
        public static void main(String[] args) {
        JavaServer server = new JavaServer();
        server.start(6666);
    }
     */
}