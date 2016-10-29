import pkg1.*;
import pkg2.*;

/**
 * Created by Tomek on 2016-10-18.
 */

public class Main {
    public static void main(String[] args){
        A a = new A(10,"Tomasz");
        B b = new B(20,"Izabela");
        C c = new C(30,"Krzysztof");

        a.print();
        b.print();
        c.print();

        a.callChangeName();
        a.callIncrement();
        a.callIncrement();

        b.callChangeName();
        b.callIncrement();
        b.callIncrement();

        c.callChangeName();
        c.callIncrement();
        c.callIncrement();

        System.out.print("\n\n\n");

        a.print();
        b.print();
        c.print();

        a.callDecrement();
        a.callDecrement();

        b.callDecrement();
        b.callDecrement();

        c.callDecrement();
        c.callDecrement();

        System.out.print("\n\n\n");

        a.print();
        b.print();
        c.print();
    }
}
