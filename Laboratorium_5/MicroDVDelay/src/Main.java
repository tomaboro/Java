import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Tomek on 14.11.2016.
 */
public class Main {
    public static void main(String[] args){
        try {
            Delay.delay("C:\\Java\\Java\\Laboratorium_5\\MicroDVDelay\\src\\gravity1.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            e.print();
            File file = new File("123");
            file.delete();
        }

        try {
            Delay.delay("C:\\Java\\Java\\Laboratorium_5\\MicroDVDelay\\src\\gravity2.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            e.print();
            File file = new File("123");
            file.delete();
        }

        try {
            Delay.delay("C:\\Java\\Java\\Laboratorium_5\\MicroDVDelay\\src\\gravity3.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            e.print();
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            e.print();
            File file = new File("123");
            file.delete();
        }

        try {
            Delay.delay("C:\\Java\\Java\\Laboratorium_5\\MicroDVDelay\\src\\gravity.txt", "gravity_delay", 1000, 30);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){e.print();}
        catch (TimeWrongFormat e){e.print();}
        catch (NegativeDisplayTime e){e.print();}
    }
}
