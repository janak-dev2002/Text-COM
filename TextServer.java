// TextServer.java
import java.io.*;
import java.net.*;

public class TextServer {
    public static void main(String[] args) {
        final int PORT = 7000;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true
            );

            // Send and receive messages
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage, serverMessage;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client: " + clientMessage);

                System.out.print("You: ");
                serverMessage = serverInput.readLine();
                out.println(serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
