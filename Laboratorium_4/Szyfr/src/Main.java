import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Tomek on 2016-11-08.
 */
public class Main {
    public static void main(String[] args) {

        Scanner odczyt = new Scanner(System.in);

        System.out.println("##############\nJakiego algorytmu chcesz użyć: \n1.Polibiusz\n2.ROT11\n##############");
        System.out.print("Podaj nr komendy: ");

        int key = odczyt.nextInt();

        if(key == 1){
            //Polibiusz p1 = new Polibiusz();
            System.out.println("##############\nCo chcesz zrobic: \n1.Syfrowac\n2.Deszyfrować\n##############");
            System.out.print("Podaj nr komendy: ");

            key = odczyt.nextInt();

            if(key==1){
                Cryptographer.cryptFile(new File(args[0]),new File(args[1]),new Polibiusz());
            }
            else if(key==2){
                Cryptographer.decryptFile(new File(args[0]),new File(args[1]),new Polibiusz());
            }

        }
        else if(key==2){
            //ROT11 r11 = new ROT11();
            System.out.println("##############\nCo chcesz zrobic: \n1.Syfrowac\n2.Deszyfrować\n##############");
            System.out.print("Podaj nr komendy: ");

            key = odczyt.nextInt();

            if(key==1){
                Cryptographer.cryptFile(new File(args[0]),new File(args[1]),new ROT11());
            }
            else if(key==2){
                Cryptographer.decryptFile(new File(args[0]),new File(args[1]),new ROT11());
            }

        }

        /*Polibiusz p1 = new Polibiusz();
        ROT11 r11 = new ROT11();

        File f1 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\t.txt");
        File f2 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\t1.txt");
        File f3 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\p.txt");
        File f4 = new File("C:\\Java\\Java\\Laboratorium_4\\Szyfr\\p1.txt");

        Cryptographer.cryptFile(f3,f4,p1);
        Cryptographer.cryptFile(f1,f2,r11);*/

    }
}

