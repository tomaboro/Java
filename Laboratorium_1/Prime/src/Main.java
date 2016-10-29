/**
 * Created by Tomek on 2016-10-12.
 */

import java.util.Scanner;
import JavaIn.JIn;

public class Main {
    public static void main(String [] arvc){

        System.out.print("Z jakiego zakresu chcesz wyswietlic liczby pierwsze??    ");

        int k = JIn.getInt();

        Prime p1 = new Prime(k);
        p1.printPrime();

    }
}
