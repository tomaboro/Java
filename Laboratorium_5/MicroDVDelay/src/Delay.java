import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Tomek on 14.11.2016.
 */
public class Delay {
    public static void delay(String in,String out,int delay, int fps)throws FileNotFoundException,MatrixDimensionsException{
        File f_in = new File(in);
        File f_out = new File(out);


        try{
            Scanner line = new Scanner(in);
            Scanner scan;
            String znak;
            String liczba;
            int klatka;
            PrintWriter zapis = new PrintWriter(f_out);

            while(line.hasNextLine()){
                scan = new Scanner(line.nextLine());
                scan.useDelimiter("");

                //Czytamy klatkę początkową
                znak = scan.next();
                if (znak.equals("{")){
                    znak = scan.next();
                    while(!znak.equals("}")){
                        liczba = liczba + znak;
                    }
                    klatka = this.StringToInt();
                }
                else throw new MatrixDimensionsException;

                //Czytamy klatkę końcową
                znak = scan.next();
                if (znak.equals("{")) {
                    znak = scan.next();
                    while (!znak.equals("}")) {
                        liczba = liczba + znak;
                    }
                    try {
                        klatka = Integer.parseInt(liczba);
                    }catch(NumberFormatException e){}
                }
                else throw new MatrixDimensionsException;

                //Przesuwamy klatke


                //Zapisujemy do pliku
            }

        }catch(FileNotFoundException e){throw e;}
    }

    private int StringToInt(String liczba){

    }
}
