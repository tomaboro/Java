/**
 * Created by Tomek on 2016-10-25.
 */
public class PracowityStudent extends Student {
    public PracowityStudent(){
        iloscZajec = 0;
    }

    public PracowityStudent(int ilZaj){
        iloscZajec = ilZaj;
    }

    public InnerPracownik rzutujNaPracownika() {
        return new InnerPracownik(iloscZajec);
    }

    public void dodajZajecia() {
        iloscZajec++;
    }

    class InnerPracownik extends Pracownik {
        public InnerPracownik(int ilZaj){
            iloscZajec = ilZaj;
        }

        public InnerPracownik(){
            iloscZajec = 0;
        }

        public void dodajZajecia() {
            iloscZajec++;
        }

        public PracowityStudent rzutujNaStudenta(){ return new PracowityStudent(iloscZajec);}

    }
}
