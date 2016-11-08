import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Tomek on 2016-11-08.
 */
public class Cryptographer {
    public static void cryptFile(File input, File output, Algorithm alg){
        try{
            Scanner in = new Scanner(input);
            PrintWriter zapis = new PrintWriter(output);

            while(in.hasNext()) {
                String word = in.nextLine();
                zapis.println(alg.cryptWord(word));
            }

            zapis.close();
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono takiego pliku");}

    }
    public static void decryptFile(File input, File output, Algorithm alg){
        try{
            Scanner in = new Scanner(input);
            PrintWriter zapis = new PrintWriter(output);

            while(in.hasNext()) {
                String word = in.nextLine();
                zapis.println(alg.decryptWord(word));
            }

            zapis.close();
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono takiego pliku");}
    }
}
