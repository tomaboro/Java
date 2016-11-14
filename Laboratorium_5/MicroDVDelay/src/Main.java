import java.util.Scanner;

/**
 * Created by Tomek on 14.11.2016.
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner("Tomek Borowicz 123").useDelimiter("");

        while(scan.hasNext()){
            System.out.println(scan.next());
        }
    }
}
