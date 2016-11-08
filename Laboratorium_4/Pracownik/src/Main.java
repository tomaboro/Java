/**
 * Created by Tomek on 2016-11-08.
 */
public class Main {
    public static void main(String[] args){

        Pesel pT = new Pesel("96070612014");
        Pesel pI = new Pesel("40051705448");
        Pesel pO = new Pesel("66052411100");
        Pesel pK = new Pesel("43050111508");

        Kadry kadry = new Kadry();

        Student Tomek = new Student(pT,1000);
        Student Iza = new Student(pI,1500);
        PracownikEtatowy Krzysiek = new PracownikEtatowy(pK,450);
        PracownikEtatowy Oskar = new PracownikEtatowy(pO,0.25);

        kadry.addPracownik(Tomek);
        kadry.addPracownik(Iza);
        kadry.addPracownik(Oskar);
        kadry.addPracownik(Krzysiek);

        kadry.findPracownik(pI).printPracownik();

        kadry.deletePracownik(pK);

        kadry.findPracownik(pO).printPracownik();

        kadry.setBruttoPracownik(kadry.findPracownikIndex(pO),5000);

        kadry.findPracownik(pO).printPracownik();
    }
}
