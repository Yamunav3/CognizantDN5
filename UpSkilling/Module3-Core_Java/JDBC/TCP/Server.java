package TCP;
import java.io.*;
import java.net.*;

public class Server {

        public static void main(String[] args) {

                try {

                        ServerSocket serverSocket = new ServerSocket(5000);

                        System.out.println("Server started...");
                        System.out.println("Waiting for client...");

                        Socket socket = serverSocket.accept();

                        System.out.println("Client connected!");

                        BufferedReader in = new BufferedReader(
                                        new InputStreamReader(
                                                        socket.getInputStream()));

                        PrintWriter out = new PrintWriter(
                                        socket.getOutputStream(),
                                        true);

                        String message = in.readLine();

                        System.out.println(
                                        "Client: " + message);

                        out.println(
                                        "Hello Client, Message Received");

                        socket.close();
                        serverSocket.close();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}