import java.io.*;
import java.net.*;

/**
 * Created by Tomek on 2016-12-13.
 */
public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        String hostName = "szymon.ia.agh.edu.pl";
        int portNumber = 3000;

        //Nawiązujemy połączenie z serwerem na danym gnieździe i otwieramy srumienie in i out
        try {
            System.out.println(InetAddress.getByName(hostName));
            echoSocket = new Socket(InetAddress.getByName(hostName), portNumber);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + hostName);
            System.exit(1);
        }

        //Logujemy się do serwera
        out.println("LOGIN");
        out.println("Szymon;OoTS");
        //Zapisujemy nasz unikalny ID
        String UserId = in.readLine();

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            out.println(UserId);
            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

