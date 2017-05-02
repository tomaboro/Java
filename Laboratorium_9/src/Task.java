import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Tomek on 2016-12-19.
 */
public class Task {
    String question;
    PrintWriter client;
    BufferedReader in;

    public Task(String question, PrintWriter client, BufferedReader in){
        this.question = question;
        this.client = client;
        this.in = in;
    }
}
