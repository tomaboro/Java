import java.util.LinkedList;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Test {
    public void test1(final double var){
        //var = 8.3;
        System.out.println("Próba zmiany warości zmiennej var kończy się błędem kompilatora.");
    }

    public void test2(final LinkedList<Double> list){
        System.out.println("Dodaje obiekty do listy...");
        list.add(2.5);
        list.add(3.456);
        list.add(6.98);
        System.out.println("Rozmiar listy to " + list.size() + ".\nJej 2 element to: " + list.get(1) + ".");
        System.out.println("Usuwam obiekt z listy...");
        list.remove(2);
    }

    //W pierwszym wypadku zmieniając wartość zmiennej zmieniamy również jej referencję
    //W drugim przypadku referencja do obiektu LinkedList jest stała w trakcie działania metody
    //W drugim przypadku nie możemy zmienić referencji obiektu, czyli dopisać list = new LinkedList<...>();
}
