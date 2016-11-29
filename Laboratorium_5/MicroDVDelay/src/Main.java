import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Tomek on 14.11.2016.
 */
public class Main {
    public static void main(String[] args){
        try {
            Delay.delay("C:\\JAVA\\Laboratorium_5\\MicroDVDelay\\src\\gravity1.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (DelayIsBig e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (Exception e){
            System.out.println("Nieobsługiwany wyjątek");
        }

        try {
            Delay.delay("C:\\JAVA\\Laboratorium_5\\MicroDVDelay\\src\\gravity2.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (DelayIsBig e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (Exception e){
            System.out.println("Nieobsługiwany wyjątek");
        }

        try {
            Delay.delay("C:\\JAVA\\Laboratorium_5\\MicroDVDelay\\src\\gravity3.txt", "123", 23, 23);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (TimeWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            System.out.println(e.getMessage());
            File file = new File("123");
            file.delete();
        }
        catch (DelayIsBig e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (Exception e){
            System.out.println("Nieobsługiwany wyjątek");
        }

        try {
            Delay.delay("C:\\JAVA\\Laboratorium_5\\MicroDVDelay\\src\\gravity.txt", "gravity_delay.txt", 1000, 30);
        }catch(FileNotFoundException e){System.out.println("Nie znaleziono pliku");}
        catch (LineWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (TimeWrongFormat e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (NegativeDisplayTime e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (DelayIsBig e){
            System.out.println(e.getMessage());
            File file = new File("gravity_delay.txt");
            file.delete();
        }
        catch (Exception e){
            System.out.println("Nieobsługiwany wyjątek");
        }
    }
}
