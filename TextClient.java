// TextClient.java
import java.io.*;
import java.net.*;

public class TextClient {
    public static void main(String[] args) {
        final String SERVER_IP = "192.168.8.155"; // or server IP
        final int SERVER_PORT = 5000;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("Connected to server");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true
            );

            // Send and receive messages
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            String serverMessage, clientMessage;

            while (true) {
                System.out.print("You: ");
                clientMessage = clientInput.readLine();
                out.println(clientMessage);

                serverMessage = in.readLine();
                if (serverMessage == null) break;
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//add new line for testing github commit
