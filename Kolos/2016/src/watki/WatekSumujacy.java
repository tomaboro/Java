package watki;

import interfejsy.SumatorInterface;
import wyjatki.WyjatekSumowania;

/**
 * Created by Tomek on 2017-01-10.
 */
public class WatekSumujacy extends Thread {
    String plik;
    SumatorInterface su;
    Wynik w;

    public WatekSumujacy(String plik, SumatorInterface su, Wynik w) {
        this.plik = plik;
        this.su = su;
        this.w = w;
    }

    @Override
    public void run(){
        try {
            w.setWynik(su.sumuj(plik));
        } catch (WyjatekSumowania wyjatekSumowania) {
            System.out.println("Wyjątek wyjatekSumowania w linii" + wyjatekSumowania.getLineNo() + ": " + wyjatekSumowania.getLine());
        }
    }
}
