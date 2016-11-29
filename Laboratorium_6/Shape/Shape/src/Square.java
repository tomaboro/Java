/**
 * Created by Tomek on 2016-10-25.
 */
public class Square extends Shape {

    public Square(String n){
        name=n;
    }
    public void draw(){
        System.out.println("Nazwa obiektu to: " + name);
        System.out.println("------------");
        System.out.println("|          |");
        System.out.println("|          |");
        System.out.println("|          |");
        System.out.println("------------");
    }
}
