/**
 * Created by Tomek on 2016-10-25.
 */
public class PracowityStudent extends Student {
    private int sumaGodzin;

    public InnerPracownik rzutujNaPracownika() {
        return new InnerPracownik();
    }

    public void printSuma(){
        System.out.println(sumaGodzin);
    }

    public void dodajZajecia() {
        iloscZajec++;
        sumaGodzin++;
    }

    class InnerPracownik extends Pracownik {
        public void dodajZajecia() {
            iloscZajec++;
            sumaGodzin++;
        }

        public void printSuma(){
            System.out.println(sumaGodzin);
        }

    }
}
