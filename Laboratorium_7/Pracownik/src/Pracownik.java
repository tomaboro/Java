import java.util.Comparator;

/**
 * Created by Tomek on 2016-11-08.
 */
public abstract class Pracownik implements Comparator<Pracownik>  {

    @Override
    // p1 < p2 --> -1
    // p1 = p2 --> 0
    // p1 > p2 --> 1
    public int compare(Pracownik p1, Pracownik p2){
        if(p1.getWynagrodzenieBrutto() < p2.getWynagrodzenieBrutto()) return 1;
        else if(p1.getWynagrodzenieBrutto() == p2.getWynagrodzenieBrutto()) return 0;
        return -1;
    }

    private String pesel;
    private double wynagrodzenieBrutto;

    public String getPesel(){
        return pesel;
    }

    public double getWynagrodzenieBrutto(){
        return wynagrodzenieBrutto;
    }

    public void setWynagrodzenieBrutto(double _brutto){
        wynagrodzenieBrutto = _brutto;
    }
    public void setPesel(String _pesel) throws IllegalStateException {
        if(Pesel.checkControlSum(_pesel)) {
            pesel = _pesel;
        }
        else throw new IllegalStateException("Niepoprawny format pesel");
    }

    Pracownik(String _pesel, double _Brutto) throws IllegalStateException{
        setWynagrodzenieBrutto(_Brutto);
        setPesel(_pesel);
    }

    public abstract double getWynagrodzenieNetto();
    public abstract void printPracownik();
}
