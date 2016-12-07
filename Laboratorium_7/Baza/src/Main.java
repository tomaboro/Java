import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Tomek on 05.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        DB db = new DB();

        Scanner odczytINT = new Scanner(System.in);
        Scanner odczytSTRING = new Scanner(System.in);

        int komenda = 0;
        String tmp;
        LinkedList<Ksiazka> ks_list;

        try{
            while(komenda != 7) {
                System.out.println("========**##**========");
                System.out.println("Co chcesz zrobić ?");
                System.out.println("1.Wyświetl całą bazę danych.");
                System.out.println("2.Wyszukaj po numerze ISBN.");
                System.out.println("3.Wyszukaj po Autorze.");
                System.out.println("4.Usuń pozycję z bazy danych(Autor).");
                System.out.println("5.Usuń pozycję z bazy danych(ISBN).");
                System.out.println("6.Dodaj pozycję");
                System.out.println("7.Zakończ program");
                System.out.println("========**##**========");
                System.out.print("Podaj numer komendy:  ");
                komenda = odczytINT.nextInt();
                System.out.println("========**##**========");

                switch (komenda) {
                    case 1:
                        printList(db.listDB());
                        break;
                    case 2:
                        System.out.print("Podaj numer ISBN jaki chcesz wyszukać:  ");
                        tmp = odczytSTRING.nextLine();
                        printList(db.searchByISBN(tmp));
                        break;
                    case 3:
                        System.out.print("Podaj autora, którego pozycje chcesz wyszukać:  ");
                        tmp = odczytSTRING.nextLine();
                        printList(db.searchByAuthor(tmp));
                        break;
                    case 4:
                        System.out.print("Podaj autora, którego chcesz usunąć z bazy:  ");
                        tmp = odczytSTRING.nextLine();
                        db.deleteByAuthor(tmp);
                        break;
                    case 5:
                        System.out.print("Podaj numer ISBN książki, którą chcesz usunąć z bazy danych:  ");
                        tmp = odczytSTRING.nextLine();
                        db.deleteByISBN(tmp);
                        break;
                    case 6:
                        String isbn, title, autor,year;
                        System.out.print("Podaj numer ISBN: ");
                        isbn = odczytSTRING.nextLine();
                        System.out.print("Podaj tytuł: ");
                        title = odczytSTRING.nextLine();
                        System.out.print("Podaj nautora: ");
                        autor = odczytSTRING.nextLine();
                        System.out.print("Podaj datę wydania: ");
                        year = odczytSTRING.nextLine();
                        db.addToDB(new Ksiazka(isbn,title,autor,year));
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Nie obsługiwana komenda.");
                }
            }
        }catch(Exception e){
            System.out.println("Błąd krytyczny! Nie obsługiwany format komendy!");
        }

    }

    public static void printList(LinkedList<Ksiazka> lista){
        for(int i =0; i<lista.size(); i++){
            lista.get(i).print();
        }
    }

}
