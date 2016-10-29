import java.io.*;

/**
 * Created by Tomek on 2016-10-17.
 */
public class Main {
    public static  void main( String [] argvc){

        System.out.println("Witaj w prograrmie do sprawdzania poprawności numerów pesel.");

        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            System.out.print("Podaj PESEL: ");
            String tmp = bfr.readLine();

            if(Pesel.checkControlSum(tmp)) System.out.println("Pesel jest poprawny.");
            else System.out.println("Pesel nie jest poprawny.");


        }catch(IOException e){e.printStackTrace();}
    }
}
