import java.util.*;

/**
 * Created by Tomek on 2016-10-18.
 */

public class Test {

    public static LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();

    public static void main(String[] args) {
       //LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();

        Scanner odczyt = new Scanner(System.in);

        int key = 0;

        try {
            while (key != 4) {
                System.out.println("#################################");
                System.out.println("1. Wczytaj punkt 3D\n" +
                        "2. Wyświetl wszystkie punkty\n" +
                        "3. Oblicz odległość\n" +
                        "4. Zakończ");
                System.out.println("#################################");

                System.out.print("Podaj numer komendy, którą chcesz wykonać:  ");

                key = odczyt.nextInt();
                System.out.println("---------------------------------");

                if (key == 1) {
                    System.out.println("Podaj współrzędne punktu.");
                    System.out.print("X: ");
                    double x = odczyt.nextDouble();
                    System.out.print("Y: ");
                    double y = odczyt.nextDouble();
                    System.out.print("Z: ");
                    double z = odczyt.nextDouble();

                    Punkt3D p = new Punkt3D(x, y, z);

                    punkty.add(p);

                    System.out.println("Punkt został pomyślnie dodany.");
                } else if (key == 2) {
                    System.out.println("Punkty zostaną wyświetlone według schematu:       indeks:  X  Y  Z");

                    for (int i = 0; i < punkty.size(); i++) {
                        System.out.println(i + ":  " + punkty.get(i).getX() + "  " + punkty.get(i).getY() + "  " + punkty.get(i).getZ());
                    }
                } else if (key == 3) {
                    System.out.println("Aby obliczyć odległość między punktami musisz podać ich indeksy na liście");

                    System.out.print("A: ");
                    int a = odczyt.nextInt();

                    System.out.print("B: ");
                    int b = odczyt.nextInt();

                    if (a > -1 && a < punkty.size() && b > -1 && b < punkty.size())
                        System.out.println(punkty.get(a).distance(punkty.get(b)));
                    else System.out.println("Indeks poza zakresem");
                } else if (key != 4) {
                    System.out.println("Nieobsługiwana komenda");
                }
            }
        }catch (java.util.InputMismatchException e){System.out.println("Błąd krytyczny! Nieobsługiwany format komendy lub liczby.");};
    }

}
