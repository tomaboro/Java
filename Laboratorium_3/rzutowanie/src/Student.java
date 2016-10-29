/**
 * Created by Tomek on 2016-10-25.
 */
abstract public class Student {
    protected int iloscZajec;
    public abstract void dodajZajecia();
    public void print(){
        System.out.println("Ilość zajęć studenta to " + iloscZajec);
    }
}
