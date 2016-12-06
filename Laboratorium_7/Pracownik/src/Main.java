/**
 * Created by Tomek on 2016-11-08.
 */
public class Main {
    public static void main(String[] args){

        Kadry kadry = new Kadry();

        Student Tomek = new Student("96070612014",1000);
        Student Iza = new Student("40051705448",1500);
        PracownikEtatowy Krzysiek = new PracownikEtatowy("66052411100",450);
        PracownikEtatowy Oskar = new PracownikEtatowy("43050111508",0.25);

        kadry.addPracownik(Tomek);
        kadry.addPracownik(Iza);
        kadry.addPracownik(Oskar);
        kadry.addPracownik(Krzysiek);

        kadry.print();

        kadry.sort();

        kadry.print();

        kadry.addListToDB();


        /*kadry.findPracownik("40051705448").printPracownik();

        kadry.deletePracownik("66052411100");

        kadry.findPracownik("43050111508").printPracownik();

        kadry.setBruttoPracownik(kadry.findPracownikIndex("43050111508"),5000);

        kadry.findPracownik("43050111508").printPracownik();*/
    }
}
