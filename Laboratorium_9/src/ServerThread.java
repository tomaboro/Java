import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Tomek on 2016-12-19.
 */
public class ServerThread extends Thread {
    Listner listen;
    int id;

    public ServerThread(Listner listen,int id){
        this.listen = listen;
        this.id = id;
    }

    public void run(){
        while(true) {
            Task theard = null;
            synchronized (listen.list) {
                if (listen.list.size() != 0) {
                    System.out.println("Wątek " + id + " zabiera sie do pracy!");
                    theard = listen.list.getFirst();
                    listen.list.removeFirst();
                }
            }

                if (theard != null) {
                    PrintWriter out = theard.client;
                    out.println(id + "   " + theard.question);
                    System.out.println(id + "   " + theard.question);

                    try {
                        theard.client.close();
                        theard.in.close();
                        out.close();
                    }catch(IOException e){}
                    theard = null;
                    System.out.println("Wątek " + id + " kończy pracę");
                }
        }
    }
}
