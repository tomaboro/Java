/**
 * Created by Tomek on 2016-12-19.
 */
public class Main {
    public static void main(String[] args) {
        Listner listner = new Listner();
        ServerThread[] tab = new ServerThread[10];

        for(int i=0; i<10; i++){
            tab[i] = new ServerThread(listner,i);
        }

        new Thread(listner).start();
        for(int i=0; i<10; i++){
            new Thread(tab[i]).start();
        }


    }
}
