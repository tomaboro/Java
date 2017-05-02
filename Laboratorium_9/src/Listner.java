import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Tomek on 2016-12-20.
 */
public class Listner extends Thread {
    LinkedList<Task> list = new LinkedList<Task>();
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        try {
            while (true) {
                System.out.println("Czekam");
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.out.println("Accept failed: 6666");
                    System.exit(-1);
                }

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Otrzymałem sygnał " + inputLine);
                    synchronized (list) {
                        list.add(new Task(inputLine, out, in));
                    }
                    //in.close();
                    break;
                }
            }
        }catch (IOException e){}

        try {
            serverSocket.close();
        }catch (IOException e){}
    }
}
