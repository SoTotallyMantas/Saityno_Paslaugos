package lt.viko.eif.m.trojanovskis.student.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaClient {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));


    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
        }

    }
    /*
    public static void main(String[] args) {
        JavaClient client = new JavaClient();
        try
        {
            client.startConnection("localhost",6666);
            String response = client.sendMessage("hello java server");
            System.out.println("Server responded: "+response);
        }
        catch (IOException e)
        {
            System.out.println("Exception occured: " + e.getMessage());
        }
        finally
        {
            client.stopConnection();
        }
    }
     */
}
