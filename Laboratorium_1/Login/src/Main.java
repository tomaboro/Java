/**
 * Created by Tomek on 2016-10-12.
 */
import java.io.*;

public class Main {
    public static  void main( String [] argvc){
        Login l1 = new Login("motek","123");

        System.out.println("Witaj wbramie do systemu nieznajomy! \nAby uzyskać dostęp musisz podać swe imię oraz tajemne hasło! \nBądź ostrożny, przed toba tylko 3 szanse...\n");


        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            for(int i = 0; i<3; i++) {

                System.out.println("Pozostałych prób: " + (3-i) );

                System.out.print("Podaj login:  ");
                String login = bfr.readLine();
                System.out.print("Podaj haslo:  ");
                String haslo = bfr.readLine();

                if (l1.check(login, haslo)){
                    System.out.println("Dane poprawne.\nWitaj w systemie nieznajomy!");
                    break;
                }
                else if (i==2) System.out.println("\nPodałeś błedny login lub hasło 3-krotnie! \nZostajesz skazany na dozywotnia banicje...");
                else System.out.println("Błędne haslo lub login :(\n");


            }
        }catch(IOException e){e.printStackTrace();}

    }
}
