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

        try{
            while(komenda != 6) {
                System.out.println("======================");
                System.out.println("Co chcesz zrobić ?");
                System.out.println("1.Wyświetl całą bazę danych.");
                System.out.println("2.Wyszukaj po numerze ISBN.");
                System.out.println("3.Usuń pozycję z bazy danych(Autor).");
                System.out.println("4.Usuń pozycję z bazy danych(ISBN).");
                System.out.println("5.Dodaj pozycję");
                System.out.println("======================");
                System.out.print("Podaj numer komendy:  ");

                komenda = odczytINT.nextInt();
                switch (komenda) {
                    case 1:
                        db.listDB();
                        break;
                    case 2:
                        System.out.print("Podaj numer ISBN jaki chcesz wyszukać:  ");
                        tmp = odczytSTRING.nextLine();
                        db.searchByISBN(tmp);
                        break;
                    case 3:
                        System.out.print("Podaj autora, którego chcesz usunąć z bazy:  ");
                        tmp = odczytSTRING.nextLine();
                        db.deleteByAuthor(tmp);
                        break;
                    case 4:
                        System.out.print("Podaj numer ISBN książki, którą chcesz usunąć z bazy danych:  ");
                        tmp = odczytSTRING.nextLine();
                        db.deleteByISBN(tmp);
                        break;
                    case 5:
                        String isbn, title, autor;
                        int year;
                        System.out.print("Podaj numer ISBN: ");
                        isbn = odczytSTRING.nextLine();
                        System.out.print("Podaj tytuł: ");
                        title = odczytSTRING.nextLine();
                        System.out.print("Podaj nautora: ");
                        autor = odczytSTRING.nextLine();
                        System.out.print("Podaj datę wydania: ");
                        year = odczytINT.nextInt();
                        db.addToDB(isbn, title, autor, year);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Nie obsługiwana komenda.");
                }
            }
        }catch(Exception e){
            e.getMessage();
        }

    }
}
