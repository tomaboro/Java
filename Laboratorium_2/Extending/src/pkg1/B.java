package pkg1;

/**
 * Created by Tomek on 2016-10-18.
 */

public class B extends A {
    public B(int _number, String _name){
        super(_number, _name);
    }

    protected void decrement(){
        number = number - 5;
    }

    void changeName(){
        name = "klasa B";
    }

    private void increment(){
        number = number + 5;
    }

    public void print(){
        System.out.println("B/C: " + name + "   " + number );
    }

}
