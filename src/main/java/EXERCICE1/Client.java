package EXERCICE1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connexion au serveur");
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Bienvenue ! Devinez le nombre magique entre 0 et 100");
                int guess = sc.nextInt();
                out.write(guess);
                int response = in.read();

                if( response == 0) {
                    System.out.println("Félicitations ! Vous avez trouvé le nombre magique!");
                    break;
                } else if (response == 1) {
                    System.out.println("Plus petit ");
                } else {
                    System.out.println("Plus grand");
                }
            }

            System.out.println("exit");
            sc.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
