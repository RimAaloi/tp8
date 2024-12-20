package EXERCICE2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        try(
                ServerSocket serverSocket = new ServerSocket(PORT);
        ) {
            System.out.println("Serveur démarré sur le port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté.");
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("error "+ e.getMessage());
        }
    }
}
