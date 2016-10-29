package pkg1;

/**
 * Created by Tomek on 2016-10-18.
 */
public class A {
    int number;
    protected String name;

    public A(int _number, String _name){
        number = _number;
        name = _name;
    }

    public void callDecrement(){
        decrement();
    }

    public void callIncrement(){
        increment();
    }

    public void callChangeName(){
        changeName();
    }

    private void increment(){
        number++;
    }

    protected void decrement(){
        number--;
    }

    void changeName(){
        name="Klasa A";
    }

    public void print(){
        System.out.println("A: " + name + "   " + number );
    }

}
