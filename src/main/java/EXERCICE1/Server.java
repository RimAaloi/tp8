package EXERCICE1;

import java.io.*;
import java.net.*;
import java.util.Random;

class Server {
    public static void main(String[] args) throws IOException {
        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Serveur démarré sur le port 1234");

            Socket clientSocket = serverSocket.accept();
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            System.out.println("Client connecté.");

            Random random = new Random();
            int magicNumber = random.nextInt(101);
            System.out.println("le nombre magique  est:"+magicNumber);

            while (true) {
                int guess = in.read();
                System.out.println("Réponse reçue : " + guess);

                if (guess == magicNumber) {
                    out.write(0);
                    System.out.println("Félicitations ! Vous avez trouvé le nombre magique.");
                    break;
                } else if (guess < magicNumber) {
                    out.write(1);
                    System.out.println("Plus petit ");
                } else {
                    out.write(-1);
                    System.out.println("Plus grand ");
                }
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
    }
