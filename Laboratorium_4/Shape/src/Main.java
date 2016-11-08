import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Shape> lista = new LinkedList<Shape>();
        Scanner odczyt = new Scanner(System.in);
        Scanner odczyt2 = new Scanner(System.in);
        Scanner odczyt3 = new Scanner(System.in);

        int key = 0;
        int key2 = 0;
        String tmp;

        try {
            while (key != 3) {
                System.out.println("#################################");
                System.out.println("1. Wyświetl wszystkie figury\n" +
                        "2. Wczytaj kształt\n" +
                        "3. Zakończ");
                System.out.println("#################################");

                System.out.print("Podaj numer komendy, którą chcesz wykonać:  ");

                key = odczyt.nextInt();
                System.out.println("---------------------------------");

                switch (key) {
                    case 1:
                        ListIterator<Shape> listIterator = lista.listIterator();
                        while (listIterator.hasNext()) {
                            listIterator.next().draw();
                        }
                        break;
                    case 2:
                        System.out.println("#################################");
                        System.out.println("1. Dodaj trójkąt.\n" +
                                "2. Dodaj koło.\n" +
                                "3. Dodaj prostokat.\n" +
                                "4. Dodaj kwadrat.");
                        System.out.println("#################################");

                        key2 = odczyt2.nextInt();

                        switch (key2) {
                            case 1:
                                System.out.print("Podaj nazwę figury: ");
                                tmp = odczyt3.nextLine();
                                lista.add(new Triangle(tmp));
                                break;
                            case 2:
                                System.out.print("Podaj nazwę figury: ");
                                tmp = odczyt3.nextLine();
                                lista.add(new Circle(tmp));
                                break;
                            case 3:
                                System.out.print("Podaj nazwę figury: ");
                                tmp = odczyt3.nextLine();
                                lista.add(new Rectangle(tmp));
                                break;
                            case 4:
                                System.out.print("Podaj nazwę figury: ");
                                tmp = odczyt3.nextLine();
                                lista.add(new Square(tmp));
                                break;
                            default:
                                System.out.println("Błędna komenda!");
                        }
                        break;
                    case (3):
                        break;
                    default:
                        System.out.println("Błędna komenda!");
                }

            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Błąd krytyczny! Nieobsługiwany format komendy lub liczby.");
        }
    }
}
