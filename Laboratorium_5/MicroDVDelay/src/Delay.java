import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Tomek on 14.11.2016.
 */
public class Delay {

    public static void delay(String in,String out,int delay, int fps)throws FileNotFoundException,LineWrongFormat,TimeWrongFormat,NegativeDisplayTime,DelayIsBig{
        //Plik, z którego bd odczytywać
        File f_in = new File(in);
        //Plik, do którego bd zapisywać
        PrintWriter zapis = new PrintWriter(out);
        //line - licznik linii
        //start stop to odpowiednio klatka początku i końca napisu
        int line = 0;
        double start,stop;
        //tresc napisów bez {}{}
        String tresc;

        try{
            //scan wczytuje po linii z pliku
            //pattern wczytuje kolejne wyrazy oddzielone delimiterem { lub }
            Scanner scan = new Scanner(f_in);
            Scanner pattern;

            while(scan.hasNextLine()) {
                String tmp = scan.nextLine();

                line++;

                if(!Pattern.matches("^\\{.+\\}\\{.+\\}.*", tmp)) throw new LineWrongFormat("Wystąpił błąd LineWrongFormat w linii " + line +"\n          " + tmp);
                if(!Pattern.matches("^\\{[0-9]+\\}\\{[0-9]+\\}.*", tmp)) throw new TimeWrongFormat("Wystąpił błąd TimeWrongFormat w linii " + line +"\n          " + tmp);

                pattern = new Scanner(tmp).useDelimiter("[\\{\\}]");
                start = Double.parseDouble(pattern.next());
                pattern.next();
                stop = Double.parseDouble(pattern.next());

                if(start > stop) throw new NegativeDisplayTime("Wystąpił błąd NegativeDisplayTime w linii " + line +"\n          " + tmp);

                tresc = pattern.next();

                start = start + delay*fps*0.001;
                stop = stop + delay*fps*0.001;;

                if(start<0 || stop<0) throw new DelayIsBig("Wystąpił błąd DelayIsBig w linii " + line +"\n          " + tmp);

                zapis.println("{"+(int) Math.round(start)+"}{"+(int) Math.round(stop)+"}"+tresc);
            }
        }//catch(FileNotFoundException e){throw e;}
        finally {
            zapis.close();
        }
        System.out.println("Napisy zostały przesunięte o " + delay +"ms, czyli "+ delay*fps*0.001 +" klatek.");
    }

}
