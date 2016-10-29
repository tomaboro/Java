package pkg2;

import pkg1.*;

/**
 * Created by Tomek on 2016-10-18.
 */

public class C extends B {

    public C(int _number, String _name){
        super(_number, _name);
    }

    void changeName(){
        name = "klasa C";
    }

}
