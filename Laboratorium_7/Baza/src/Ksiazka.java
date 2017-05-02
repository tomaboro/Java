/**
 * Created by Tomek on 07.12.2016.
 */
public class Ksiazka {
    public String isbn;
    public String tytul;
    public String autor;
    public String rok;

    Ksiazka(String isbn,String tytul,String autor,String rok){
        this.tytul = tytul;
        this.isbn = isbn;
        this.autor = autor;
        this.rok = rok;
    }

    public void print(){
        System.out.println(isbn + "  " + tytul + "  " + autor + "  " + rok);
    }

}
