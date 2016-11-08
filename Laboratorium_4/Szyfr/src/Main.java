import java.io.File;

/**
 * Created by Tomek on 2016-11-08.
 */
public class Main {
    public static void main(String[] args){
        Polibiusz p1 = new Polibiusz();
        ROT11 r11 = new ROT11();

        File f1 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\t.txt");
        File f2 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\t1.txt");
        File f3 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\p.txt");
        File f4 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\p1.txt");

        Cryptographer.cryptFile(f3,f4,p1);
        Cryptographer.cryptFile(f1,f2,r11);

    }
}
