package watki;

import interfejsy.MnoznikInterface;
import wyjatki.WyjatekMnozenia;
import wyjatki.WyjatekSumowania;

/**
 * Created by Tomek on 2017-01-10.
 */
public class WatekMnozacy extends Thread {
    String plik;
    int wiersz;
    MnoznikInterface mi;
    Wynik w;

    public WatekMnozacy(String plik, int wiersz, MnoznikInterface mi, Wynik w) {
        this.plik = plik;
        this.wiersz = wiersz;
        this.mi = mi;
        this.w = w;
    }

    @Override
    public void run(){
        try {
            w.setWynik(mi.mnoz(plik,wiersz));
        } catch (WyjatekMnozenia wyjatekMnozenia) {
            System.out.println("Wyjątek wyjatekMnozenia w linii" + wyjatekMnozenia.getColNo() + ": " + wyjatekMnozenia.getLine());
        }
    }
}
