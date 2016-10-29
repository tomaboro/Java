/**
 * Created by Tomek on 2016-10-12.
 */
package JavaIn;

import java.io.*;
import java.util.Scanner;

public class JIn {

    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    public static int getInt(){
        int i;

        try {
            Scanner odczyt = new Scanner(System.in);
            i = odczyt.nextInt();
        }catch(java.util.InputMismatchException e){
            System.out.println(" To nie jest liczba całkowita!      przypisuje domyslne 0!");
            i = 0;
        }
        return i;
    }
}
