/**
 * Created by Tomek on 2016-10-25.
 */
public class Rectangle extends Shape {

    public Rectangle(String n){
        name=n;
    }
    public void draw(){
        System.out.println("Nazwa obiektu to: " + name);
        System.out.println("------------------");
        System.out.println("|                |");
        System.out.println("|                |");
        System.out.println("|                |");
        System.out.println("------------------");
    }
}
