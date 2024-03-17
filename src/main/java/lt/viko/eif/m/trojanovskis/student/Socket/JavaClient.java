package lt.viko.eif.m.trojanovskis.student.Socket;

import lt.viko.eif.m.trojanovskis.student.menu.Menu;
import lt.viko.eif.m.trojanovskis.student.util.FileOperations;
import lt.viko.eif.m.trojanovskis.student.util.GenericList;
import lt.viko.eif.m.trojanovskis.student.util.JaxbUtil;
import lt.viko.eif.m.trojanovskis.student.util.ValidateXMLFile;
import lt.viko.eif.m.trojanovskis.student.xsdtest.List;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class JavaClient {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void startClient() {
        JavaClient client = new JavaClient();
        try {
            GenericList<Object> genericList = new GenericList<>();
            List list = new List();
            client.startConnection("localhost", 6666);
            client.sendMessage("hello java server ");
            String response = client.receiveMessage();
            System.out.println("Server responded: " + response);
            String xmlString = "";
            if (Objects.equals(response, "ok")) {
                String Input;
                do {
                    Menu.showMenu();
                    Input = Integer.toString(Menu.selection());
                    client.sendMessage(Input);
                    response = client.receiveMessage();
                    if (Input.equals("5") || Input.equals("6")) {
                        xmlString = printXMLMessage(client);
                        FileOperations.WriteToFile("XMLObjectReceived.xml", xmlString);
                        System.out.println(ValidateXMLFile.validateXMLSchema("JAXBObject.xsd", "XMLObjectReceived.xml"));
                        if (Input.equals("6")) {
                            genericList = JaxbUtil.transformToPOJO(Object.class, new File("XMLObjectReceived.xml"), new File("JAXBObject.xsd"));
                            genericList.getData().forEach(System.out::println);

                        }
                    }
                    else {
                        printMessage(client);
                    }
                    //System.out.println(response);



                } while (!Input.equals("7"));
            }
        } catch (IOException e) {
            System.out.println("Exception occured: " + e.getMessage());
        } finally {
            client.stopConnection();
        }
    }

    private static String printXMLMessage(JavaClient client) throws IOException {
        String response = "";
        StringBuilder xmlString = new StringBuilder();
        do {
            System.out.println(response);
            xmlString.append(response).append("\n");
            response = client.receiveMessage();

        } while (!response.equals("Finished"));
        return xmlString.toString();
    }

    public static void printMessage(JavaClient client) throws IOException {

        String response = "";
        do {
            System.out.println(response);

            response = client.receiveMessage();

        } while (!response.equals("Finished"));

    }

    public void startConnection(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));


    }

    public void sendMessage(String msg) throws IOException {
        out.println(msg);

    }

    public String receiveMessage() throws IOException {
        return in.readLine();
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

}
