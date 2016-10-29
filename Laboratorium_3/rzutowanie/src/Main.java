/**
 * Created by Tomek on 2016-10-25.
 */
public class Main {
    public static void main(String[] args){
        PracowityStudent Iza = new PracowityStudent();
        Iza.dodajZajecia();
        Iza.dodajZajecia();
        Iza.dodajZajecia();
        Iza.print();

        PracowityStudent.InnerPracownik Tomek = Iza.rzutujNaPracownika();

        Tomek.dodajZajecia();
        Tomek.print();

        Iza = Tomek.rzutujNaStudenta();
        Iza.dodajZajecia();
        Iza.print();

    }
}

