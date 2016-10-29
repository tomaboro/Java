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
        Iza.printSuma();

        PracowityStudent.InnerPracownik Tomek = Iza.rzutujNaPracownika();

        Tomek.dodajZajecia();
        Iza.print();
        Tomek.print();
        Tomek.printSuma();

    }
}

//Nie kompiluje sie ze względu na kilka literówek XD
//rzutujNaPracownika tworzy nowy obiekt i zwraca jego referencję więc pola nowego obiektu oraz 'starego' nie sa powiazane
//Metody klas wewnętrznych mają bezpośredni dostęp do wszystkich pól i metod klasy w której się zawierają więc sumagodzin się nie zeruje

