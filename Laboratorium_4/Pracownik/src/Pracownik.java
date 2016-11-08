import java.util.Scanner;

/**
 * Created by Tomek on 2016-11-08.
 */
public abstract class Pracownik {

    private Pesel pesel;
    private double wynagrodzenieBrutto;

    public Pesel getPesel(){
        return pesel;
    }

    public double getWynagrodzenieBrutto(){
        return wynagrodzenieBrutto;
    }

    public void setWynagrodzenieBrutto(double _brutto){
        wynagrodzenieBrutto = _brutto;
    }

    Pracownik(Pesel _pesel, double _Brutto){
        pesel = _pesel;
        wynagrodzenieBrutto = _Brutto;
    }

    Pracownik(){
        insertPracownik();
    }

    public void insertPracownik(){
        Scanner odczyt = new Scanner(System.in);
        String _pesle = odczyt.next();
        double _brutto = odczyt.nextDouble();
        pesel = new Pesel(_pesle);
        wynagrodzenieBrutto = _brutto;
    }

    public abstract double getWynagrodzenieNetto();
    public abstract void printPracownik();
}
