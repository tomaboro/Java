/**
 * Created by Tomek on 2016-10-25.
 */
abstract public class Pracownik {
    protected int iloscZajec;
    public abstract void dodajZajecia();
    public void print(){
        System.out.println("Ilość zajęć pracownika to " + iloscZajec);
    }
}
