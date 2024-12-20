package EXERCICE2;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final int PORT = 1234;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        new Client().connect();
    }

    public void connect() {
        try(
                Socket socket = new Socket(HOST, PORT);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connexion au serveur " + PORT);
            interact(bufferedReader, consoleReader, printWriter);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void interact(BufferedReader bufferedReader, BufferedReader consoleReader, PrintWriter printWriter) throws Exception{
        while ( true ) {
            String line = bufferedReader.readLine();
            if (line == null || line.contains("quelle fichier")) {
                break;
            }
            System.out.println(line);
        }

        System.out.print("Entrez le nom du fichier à demander : ");
        String filename = consoleReader.readLine();
        printWriter.println(filename);

        while ( true ) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

}
